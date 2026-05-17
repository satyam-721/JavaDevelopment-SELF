package com.satyam;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App{
    public static void main(String args[]){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee emp = context.getBean("employee",Employee.class);
        emp.show();



        Laptop lap = context.getBean(Laptop.class);
        System.out.println(lap.getA());



    }
}
