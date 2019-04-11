package com.example.quickkills.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/6
 */
public class test {

    public static void main(String args[]){
        Long a1=System.currentTimeMillis();
        System.out.println("a1-----------------"+a1);
        for (int i=0;i<10000;i++){
            Map a =new HashMap();
           /* Long a2=System.currentTimeMillis();
            System.out.println("a2-a1-----------------"+(a2-a1));*/
            a.put("test","test");
            a.get("test");
        }

        Long a3=System.currentTimeMillis();
        System.out.println("a3-a2-----------------"+(a3-a1));
    }
}
