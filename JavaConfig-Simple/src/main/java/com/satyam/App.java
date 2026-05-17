package com.satyam;

import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main( String[] args ) {

        //creating a container
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee emp = context.getBean(Employee.class);
        emp.work();
        System.out.println();


        Laptop lap = context.getBean(Laptop.class);
        lap.giveLaptop();



    }

}
