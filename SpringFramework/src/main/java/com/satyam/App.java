package com.satyam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main( String[] args ) {

        //creating a container
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        //getting object
        Employee obj = (Employee) context.getBean("employee");  //returns an object

//        obj.work();


        //as this is employee2 means this is different constructor
        Employee obj1 =(Employee) context.getBean("employee2");

        //This will create new object. refer to xml file to understand
        Employee obj2=(Employee) context.getBean("employee2");
        System.out.println(obj1);
        System.out.println(obj2);



        //Injection
        Employee obj3 = (Employee) context.getBean("employee3");
        System.out.println(obj3.getAge());
        obj3.work();




    }

}
