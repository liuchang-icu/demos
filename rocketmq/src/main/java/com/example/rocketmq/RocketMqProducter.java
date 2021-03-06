package com.example.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * MQ生产者
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/5
 */
@Component
public class RocketMqProducter{
    @Value("${rocketmq.nameSrvAddr}")
    private String nameSrvAddr;
    @Value("${rocketmq.groupName}")
    private String groupName;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final DefaultMQProducer producer = new DefaultMQProducer("Test");
    /**
     * 初始化
     */
    @PostConstruct
    public void start() {
        try {
            LOGGER.info("MQ：启动生产者");
            producer.setNamesrvAddr(nameSrvAddr);
            producer.start();
        } catch (MQClientException e) {
            LOGGER.error("MQ：启动生产者失败：{}-{}", e.getResponseCode(), e.getErrorMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 发送消息
     *
     * @param data  消息内容
     * @param topic 主题
     * @param tags  标签
     * @param keys  唯一主键
     */
    public void sendMessage(String data, String topic, String tags, String keys) {
        try {
            byte[] messageBody = data.getBytes(RemotingHelper.DEFAULT_CHARSET);

            Message mqMsg = new Message(topic, tags, keys, messageBody);

            producer.send(mqMsg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    LOGGER.info("MQ: 生产者发送消息 {}", sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    LOGGER.error(throwable.getMessage(), throwable);
                }
            });
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    @PreDestroy
    public void stop() {
        if (producer != null) {
            producer.shutdown();
            LOGGER.info("MQ：关闭生产者");
        }
    }


}
