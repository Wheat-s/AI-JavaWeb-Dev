package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(5)
@Component
//@Aspect
public class MyAspect3 {
    //前置通知
    @Before("execution(* com.itheima.service.impl.*.*(..))")
    public void before(){
        log.info("MyAspect3 -> before ...");
    }

    //后置通知
    @After("execution(* com.itheima.service.impl.*.*(..))")
    public void after(){
        log.info("MyAspect3 ->  after ...");
    }
}