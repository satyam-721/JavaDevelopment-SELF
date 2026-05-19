package com.satyam.Jobapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SelfInvocation_problem {

    @Before("execution(* com.satyam.Jobapp.service.JobService.display(..))")
    public void log() {
        System.out.println("AOP Executed");
    }

//    methodA()
//   ↓
//    directly methodB()
    // Bypasses Proxy
    //AOP Executed never prints


    //this shows there is no direct injection of aop inside methods. proxy is created for methods
}
