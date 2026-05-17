package com.satyam.demo;

import com.satyam.demo.model.Student;
import com.satyam.demo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

        Student obj1 = context.getBean(Student.class);

        obj1.setId(100);
        obj1.setName("harsh");
        obj1.setCgpa(5.3f);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(obj1);

        

	}

}
