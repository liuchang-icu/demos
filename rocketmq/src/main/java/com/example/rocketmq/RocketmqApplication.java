package com.example.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootApplication
public class RocketmqApplication {
    public static void main(String[] args) {
       /* SpringApplication.run(RocketmqApplication.class, args);*/
        ApplicationContext context = SpringApplication.run(RocketmqApplication.class,args);
        RocketMqProducter producter = context.getBean(RocketMqProducter.class);
        for (int i = 0; i < 10000; i++) {
            producter.sendMessage("Hello RocketMQ " + i, "TopicTest",
                    "TagTest", "Key" + i);
        }
    }
}
