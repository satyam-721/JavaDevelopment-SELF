package com.satyam.demo.service;

import com.satyam.demo.model.Student;
import com.satyam.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepo repo;


    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student stu){
        repo.save(stu);
    }
}
