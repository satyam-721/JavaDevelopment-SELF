package com.satyam.Jobapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//use to monitor performance
@Component
@Aspect
public class PerformanceMonitoringAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    //return an Object for Around

    @Around("execution(* com.satyam.Jobapp.service.JobService.*(..))")
    public Object monitorTime( ProceedingJoinPoint pjp) throws Throwable {

        //occurs before function execution
        long start = System.currentTimeMillis();

        Object obj = pjp.proceed();   //calling the method

        //Occurs after function executed
        long end = System.currentTimeMillis();

        LOGGER.info("Time Taken: "+ pjp.getSignature().getName()+ (end - start));

        return obj;
    }
}
