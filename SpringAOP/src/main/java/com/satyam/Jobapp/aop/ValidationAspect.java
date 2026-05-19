package com.satyam.Jobapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    //accepting an argument og getJob method
    @Around("execution(* com.satyam.Jobapp.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp,int postId) throws Throwable {
//        System.out.println(postId);
        if (postId<0){

            LOGGER.info("postId is negative");
            postId = -postId;
            LOGGER.info("Updated postId to positive");
        }

        Object obj =  jp.proceed(new Object[]{postId});    //sending updated argument in an array


        return obj;

    }
}
