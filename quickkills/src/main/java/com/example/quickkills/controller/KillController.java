package com.example.quickkills.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/6
 */
@RestController()
public class KillController {
    @GetMapping("/kill")
    String kill(@RequestParam String userId){

        return null;
    }
}
