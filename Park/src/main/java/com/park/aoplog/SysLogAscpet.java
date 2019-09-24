package com.park.aoplog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Auther: 林深时见鹿
 * @Date: 2019/9/10 10:35
 * @Description:日志切面
 */


@Aspect
@Component
public class SysLogAscpet {

    @Pointcut("execution(* com.park..*.*(..))")
    public void logPoint(){}


    @After("logPoint()")
    public void after(JoinPoint joinPoint){
        System.out.println("日志操作========");
    }



}
