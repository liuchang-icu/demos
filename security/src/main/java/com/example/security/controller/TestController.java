package com.example.security.controller;

import com.example.security.model.Sys_user;
import com.example.security.service.impl.Sys_permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/14
 */
@RestController
public class TestController {
    @Autowired
    Sys_permission sys_permission;
    @RequestMapping("/test")
    public Map test(){
        return sys_permission.findAll();
    }
}
