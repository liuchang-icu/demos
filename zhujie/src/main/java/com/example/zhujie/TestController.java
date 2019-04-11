package com.example.zhujie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**注解测试接口
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/5/29
 */
@RestController
public class TestController {


    @GetMapping (value="/")
    @MyZhujie(value="aaaaaa")
    public boolean test(){
        return true;
    }
}
