package com.example.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/13
 */
@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //页面请求
    @GetMapping("/login")
    public void socket(@RequestParam String name, HttpSession session) {
        session.setAttribute("name",name);
        logger.info(name+"登录成功");
    }
    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public void pushToWeb(@PathVariable String cid,String message) {

        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}