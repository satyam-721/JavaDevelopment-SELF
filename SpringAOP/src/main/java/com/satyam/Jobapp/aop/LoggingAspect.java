package com.satyam.Jobapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //execution( return type, fullyQualified Class name, method name, args )
    //ADVICE (POINTCUT)
    @Before("execution(* com.satyam.Jobapp.service.JobService.*(..))")

    public void logMethodCall(JoinPoint jp){

        //printing into console
        LOGGER.info("Method Called: "+jp.getSignature().getName());
    }

    //after the method execution. (works like finally)
    @After("execution(* com.satyam.Jobapp.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info(jp.getSignature().getName()+" Executed !");

    }
    //when exception occurs (without catching it)
    @AfterThrowing("execution(* com.satyam.Jobapp.service.JobService.getJob(..))")
    public void logMethodException(JoinPoint jp){
        LOGGER.info(jp.getSignature().getName()+" Has some issue ");

    }

    //After successfully execution and returning
    @AfterReturning("execution(* com.satyam.Jobapp.service.JobService.getJob(..))")
    public void logMethodExecutedSuccessfully(JoinPoint jp){
        LOGGER.info(jp.getSignature().getName()+" Executed Successfully");

    }

}
