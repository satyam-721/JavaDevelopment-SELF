package com.satyam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWired {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Education edu =(Education) context.getBean("edu");
        edu.getWork();


    }
}
