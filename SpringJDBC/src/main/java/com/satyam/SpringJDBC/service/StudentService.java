package com.satyam.SpringJDBC.service;

import com.satyam.SpringJDBC.model.Student;
import com.satyam.SpringJDBC.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s){
        repo.save(s);
    }

    public List<Student> getStudents(Student s) {
        return repo.findAll(s);

    }
}
