package com.satyam.learn;

import com.satyam.learn.model.Laptop;
import com.satyam.learn.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootLearningApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootLearningApplication.class, args);

        Laptop lap = context.getBean(Laptop.class);
        LaptopService service = context.getBean(LaptopService.class);
        service.addLaptop(lap);


//
//        Employee obj = context.getBean(Employee.class);
//        obj.code();
//        obj.setId(1);
//
//        Employee obj2 = context.getBean(Employee.class);
//        obj2.code();
//
//
//        System.out.println(obj);
//        System.out.println(obj2);
//        System.out.println(obj2.getId());
//        obj2.doWork();





	}

}
