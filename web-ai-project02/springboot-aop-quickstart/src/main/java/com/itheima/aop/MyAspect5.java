package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class MyAspect5 {
    //前置通知
    //@Before("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    //@Before("execution(void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    //@Before("execution(void delete(java.lang.Integer))") //包名.类名 强烈不建议省略
    //@Before("execution(* com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    //@Before("execution(* com.*.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    //@Before("execution(* com.itheima.service.impl.*.delete(java.lang.Integer))")
    //@Before("execution(* com.itheima.service.impl.*.*(java.lang.Integer))")
    //@Before("execution(* com.itheima.service.impl.*.*(*))")
    //@Before("execution(* com.itheima.service.impl.*.del*(*))")
    //@Before("execution(* com.itheima.service.impl.*.*e(*))")
    //@Before("execution(* com..service.impl.DeptServiceImpl.*(..))")
    //@Before("execution(* com.itheima.service.*.*(..))")

    //匹配list 与 delete 方法
    //@Before("execution(* com.itheima.service.impl.DeptServiceImpl.list(..)) ||" +
    //        "execution(* com.itheima.service.impl.DeptServiceImpl.delete(..))")

    @Before("@annotation(com.itheima.anno.LogOperation)")
    public void before(){
        log.info("MyAspect5 -> before ...");
    }

}
