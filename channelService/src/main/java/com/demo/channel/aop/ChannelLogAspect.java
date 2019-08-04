package com.demo.channel.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Arrays;

//todo 测试
@Aspect
@Component
@Slf4j
public class ChannelLogAspect {
    /**
     * 定义切入点，切入点为com.demo.channel.controller下的所有函数
     * 修改* ，（..）,throw 拦截指定方法的返回 传参 还有 抛出异常拦截
     */
    @Pointcut("execution(public * com.demo.channel.controller..*.*(..))")
    public void ChannelLog() {
    }

    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint
     */
    @Before("ChannelLog()")
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // 记录下请求内容
        HttpServletRequest request = attributes.getRequest();
        log.info("URL : {},HTTP_METHOD :{},IP : {},CLASS_METHOD : {},ARGS : {},DATE;{}" ,
                request.getRequestURL().toString(),
                request.getMethod(),
                request.getRemoteAddr(),
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()),
                LocalDate.now());
    }

    @AfterReturning(returning = "ret", pointcut = "ChannelLog()")
    public void doAfterReturning(Object ret){
        // 处理完请求，返回内容
        log.info("RESPONSE : {} ", ret);
    }
}
