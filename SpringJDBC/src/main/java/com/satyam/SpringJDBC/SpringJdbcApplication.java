package com.satyam.SpringJDBC;

import com.satyam.SpringJDBC.model.Student;
import com.satyam.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringJdbcApplication.class, args);

        Student obj1 = context.getBean(Student.class);
        obj1.setName("satyam");
        obj1.setMarks(78);
        obj1.setRoll(174);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(obj1);

        List<Student> studentList = service.getStudents(obj1);
        System.out.println(studentList);

        

	}

}
