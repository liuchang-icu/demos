package com.example.zhujie;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 注解测试类
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/5/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestControllerTest {
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void test1()  throws Exception{
        MvcResult mvcResult = mockMvc
                .perform(// 1s
                        MockMvcRequestBuilders.get("/") // 2
                                .param("name","admin") // 3
                ).andExpect(status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn();// 4

        int status = mvcResult.getResponse().getStatus(); // 5
        String responseString = mvcResult.getResponse().getContentAsString(); // 6

        Assert.assertEquals("请求错误", 200, status); // 7
        Assert.assertEquals("返回结果不一致", "true", responseString); // 8
       /*
        参考自：
        https://www.cnblogs.com/0201zcr/p/5756642.html
        https://www.jianshu.com/p/8308fd12d0cb
        https://segmentfault.com/a/1190000011420910*/
    }
}