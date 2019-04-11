package com.example.websocket_stomp.controller;

import com.example.websocket_stomp.beans.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/13
 */
@Controller
public class WebsocketTestController {
    @MessageMapping("/chat")
    public Message chat(){
        return null;

    }
}
