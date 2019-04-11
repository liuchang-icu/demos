package com.example.zhujie;

import java.lang.annotation.*;

/**
 * 自定义注解类
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/5/29
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyZhujie {
    String value() default "";
}
