package com.example.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * Mq消费者
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/5
 */
@Component
public class RocketMqPushConsumer implements MessageListenerConcurrently {

    @Value("${rocketmq.nameSrvAddr}")
    private String nameSrvAddr;

    @Value("${rocketmq.groupName}")
    private String groupName;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("Test");
    @PostConstruct
    public void start() {
        try {
            LOGGER.info("MQ：启动消费者");
            consumer.setNamesrvAddr(nameSrvAddr);
            // 从消息队列头开始消费
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            // 集群消费模式
          /*  consumer.setMessageModel(MessageModel.CLUSTERING);*/
            // 订阅主题
            consumer.subscribe("TopicTest", "*");
            // 注册消息监听器
            consumer.registerMessageListener(this);
            // 启动消费端
            consumer.start();
        } catch (MQClientException e) {
            LOGGER.error("MQ：启动消费者失败：{}-{}", e.getResponseCode(), e.getErrorMessage());
            throw new RuntimeException(e.getMessage(), e);
        }

    }
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        //每一个商品的id：数量放redis    消费一次+1  超过库存不再消费
        //异常
        int index=0;
        try {
            for (; index < msgs.size(); index++) {
                System.out.println("msgs----size>>>>>>>>"+msgs.size());
                MessageExt msg = msgs.get(index);

                String messageBody = new String(msg.getBody(), RemotingHelper.DEFAULT_CHARSET);
                //

                LOGGER.info("MQ：消费者接收新信息: {} {} {} {} {}", msg.getMsgId(), msg.getTopic(), msg.getTags(), msg.getKeys(), messageBody);
                //更新redis库存
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (index < msgs.size()) {
                consumeConcurrentlyContext.setAckIndex(index + 1);
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        /*int index = 0;
        try {
            for (; index < msgs.size(); index++) {
                MessageExt msg = msgs.get(index);

                String messageBody = new String(msg.getBody(), RemotingHelper.DEFAULT_CHARSET);
                //

                LOGGER.info("MQ：消费者接收新信息: {} {} {} {} {}", msg.getMsgId(), msg.getTopic(), msg.getTags(), msg.getKeys(), messageBody);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (index < msgs.size()) {
                consumeConcurrentlyContext.setAckIndex(index + 1);
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;*/
    }
    @PreDestroy
    public void stop() {
        if (consumer != null) {
            consumer.shutdown();
            LOGGER.error("MQ：关闭消费者");
        }
    }
}
