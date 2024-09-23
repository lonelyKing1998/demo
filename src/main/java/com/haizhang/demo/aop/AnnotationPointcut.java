package com.haizhang.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationPointcut {

    @Pointcut("execution(* com.haizhang.demo.*.*.*(..))")
    public void pointcut(){
        // 这是一个切点签名，所有在service包下的方法都将被匹配
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        // 前置通知，在方法执行前打印日志
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Executing: " + methodName);
    }

}
