package com.wheat.aop;

import com.wheat.mapper.OperateLogMapper;
import com.wheat.pojo.OperateLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * AOP 切面类：用于记录系统中所有带有 @Log 注解的方法的操作日志。
 */
@Slf4j  // Lombok 注解，自动生成日志对象 log
@Aspect  // 表示这是一个切面类
@Component  // 表示该类会被 Spring 管理（自动扫描）
@RequiredArgsConstructor  // Lombok 注解，为 final 字段生成构造方法
public class OperateLogAspect {

    /**
     * 自动注入操作日志的 Mapper 接口，用于将日志信息保存到数据库
     */
    @Autowired
    private OperateLogMapper operateLogMapper;

    /**
     * 环绕通知：拦截所有带有 @Log 注解的方法，并记录操作日志
     *
     * @param joinPoint 连接点对象，包含目标方法的所有信息
     * @return 方法执行的结果
     * @throws Throwable 如果目标方法抛出异常，则继续抛出
     */
    @Around("@annotation(com.wheat.anno.Log)")  // 拦截带有 @Log 注解的方法
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {

        // 获取操作开始时间（单位：毫秒）
        long startTime = System.currentTimeMillis();

        // 执行目标方法
        Object result = joinPoint.proceed();

        // 计算方法执行耗时
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;

        // 构建操作日志实体对象
        OperateLog oLog = new OperateLog();
        oLog.setOperateEmpId(getCurrentUserId()); // 设置操作人 ID（需根据实际项目获取）
        oLog.setOperateTime(LocalDateTime.now());  // 设置操作时间
        oLog.setClassName(joinPoint.getTarget().getClass().getName());  // 设置目标类名
        oLog.setMethodName(joinPoint.getSignature().getName());  // 设置目标方法名
        oLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));  // 设置方法参数（转为字符串）
        oLog.setReturnValue(result != null ? result.toString() : "void");  // 设置返回值（转为字符串）
        oLog.setCostTime(costTime);  // 设置方法执行耗时

        // 保存操作日志到数据库
        log.info("记录操作日志: {}", log);
        operateLogMapper.insert(oLog);

        return result;
    }

    /**
     * 获取当前登录用户的 ID
     *
     * 在实际项目中，应从安全上下文（如 Spring Security 或 ThreadLocal）中获取当前用户信息
     * 示例中返回一个固定值，仅用于演示
     *
     * @return 当前用户 ID
     */
    private Integer getCurrentUserId() {
        // 实现获取当前登录用户的逻辑

        // 示例返回一个固定值，实际开发中需要根据实际需求进行修改
        return 1;
    }
}
