package com.example.rocketmq.controller;

import com.example.rocketmq.RocketMqProducter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 秒杀
 * ABCDEF 5个商品，每个商品有10个
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/6
 */
@RestController
public class KillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RocketMqProducter mqProducer;
    //params 商品ID，用户Id
    @PostMapping("/kill")
    public boolean kill(@RequestParam Map<String,String> params){
        //先把用户ID和商品ID拼起来放Redis 二次请求直接返回等待结果页面
        try {
            mqProducer.sendMessage(params.toString(),"killTopic",params.get("mcdsId"),"key-kill");
            return true;   //消息发送成功，返回等待结果页面
        }catch (Exception e){
            return false;
        }
    }

    @GetMapping("/getKillResault")
    public String getKillResault(@RequestParam String mcdsId,HttpSession session){
        //从订单表获取本人秒杀商品的订单信息
        return null;
    }
}

