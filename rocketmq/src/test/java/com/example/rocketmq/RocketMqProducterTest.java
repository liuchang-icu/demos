package com.example.rocketmq;

import org.apache.rocketmq.client.producer.MQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**MQ测试类
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RocketMqProducterTest {
    @Resource
    private RocketMqProducter mqProducer;

    @Test
    public void start() {
    }

    @Test
    public void sendMessage() {
        for (int i = 0; i < 1000; i++) {
            mqProducer.sendMessage("Hello RocketMQ " + i, "TopicTest",
                    "TagTest", "Key" + i);
        }
    }

    @Test
    public void stop() {
    }
}