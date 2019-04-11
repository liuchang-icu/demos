package com.example.zhujie;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * 自定义切面
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/5/29
 *
 *
 * within()和execution()函数不同的是，within()所指定的连接点最小范围只能是类，
 * 而execution()所指定的连接点可以大到包，小到方法入参。 所以从某种意义上讲，
 * execution()函数功能涵盖了within()函数的功能
 */

@Aspect
@Component
public class  OperateAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("@annotation(com.example.zhujie.MyZhujie)")
    public  void annotationPointCut() {

    }
    @Before("annotationPointCut()")
    //@Before("within(@com.example.zhujie.TestController *)")
    public void before(JoinPoint joinPoint){
        //获取连接点的方法签名对象
        MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
        //获取方法请求参数
        Object[] params=joinPoint.getArgs();
        Method method = sign.getMethod();
        /*java.lang.Object getThis() 获取代理对象本身；
        ProceedingJoinPoint继承JoinPoint子接口，它新增了两个用于执行连接点方法的方法：
        java.lang.Object proceed() throws java.lang.Throwable：通过反射执行目标对象的连接点处的方法；
        java.lang.Object proceed(java.lang.Object[] args) throws java.lang.Throwable：通过反射执行目标对象连接点处的方法，不过使用新的参数替换原来的参数。*/
        MyZhujie annotation = method.getAnnotation(MyZhujie.class);
        System.out.print(" 对象"+sign+" 方法："+method.getName()+" 方法入参"+params.toString()+" 注解参数"+annotation.value()+" 前置/n");

    }
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        logger.info("JoinPoint:{}" , joinPoint.toString());
    }
   // @AfterReturning(returning="rvt", pointcut="annotationPointCut()")
    @AfterReturning(returning="rvt", value = "within(com.example.zhujie.TestController)")
    // 声明rvt时指定的类型会限制目标方法必须返回指定类型的值或没有返回值
    // 此处将rvt的类型声明为Object，意味着对目标方法的返回值不加限制
    public void log(Object rvt)
    {
        logger.info("获取目标方法返回值:{}" ,rvt);
    }
}
