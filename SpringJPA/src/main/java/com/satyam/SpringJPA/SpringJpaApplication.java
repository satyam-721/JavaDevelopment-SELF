package com.satyam.SpringJPA;

import com.satyam.SpringJPA.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);

        Student st=context.getBean(Student.class);
        st.setRoll(12);
        st.setMarks(71);
        st.setName("satyam");

        Student st2=context.getBean(Student.class);
        st2.setRoll(12);
        st2.setMarks(80);
        st2.setName("sagar");

        Student st3=context.getBean(Student.class);
        st3.setRoll(14);
        st3.setMarks(71);
        st3.setName("prasad");

        StudentRepo repo = context.getBean(StudentRepo.class);

        //To save the data in Database
//        repo.save(st);

        //to fetch the data from db
        System.out.println(repo.findAll());

        System.out.println(repo.findById(13));  //get data based on primary key

        System.out.println(repo.findByName("satyam"));

        System.out.println(repo.findByMarksGreaterThan(70));


        //UPDATE
        //if the id is already present in db , it will update the table
        repo.save(st2);



        //DELETE
//        repo.delete(st);   //delete based on id or primary key
	}

}
