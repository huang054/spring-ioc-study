package com.example.springMvc.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
@Component
@Aspect
public class MethodExecutionTime {

    //    @Around("execution(* *.*(..)) && @annotation(com.aspectj.demo.aspect.MonitorMethod)")
    @Around("execution(* *.*(..)) && @annotation(method)")
    public Object profile(ProceedingJoinPoint pjd,AnnTest method) throws Throwable {
        Object result = null;
        System.out.println(method.value());
        // 这里可以获取方法名
        System.out.println(pjd.getSignature().getName());
        System.out.println(pjd.getTarget());
        // 获取方法名
        Method[] methods = pjd.getSignature().getDeclaringType().getMethods();
        System.out.println(methods[0]);

        // 获取参数信息
        Object[] args = pjd.getArgs();
        for (Object o : args) {
            System.out.println(o.toString());
        }
        try {
            System.out.println("前置通知");
            result = pjd.proceed();
            System.out.println("后置通知");
        } catch (Throwable e) {
            // System.out.println("异常通知");
        }
        // System.out.println("返回通知");
        return result;
    }
}
