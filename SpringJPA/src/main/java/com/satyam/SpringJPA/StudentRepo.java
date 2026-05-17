package com.satyam.SpringJPA;

import com.satyam.SpringJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {      //<classtype,primarykey type>

    //in sql query we use table and columnName,
    //in JPQL we use class and property name.


    //making a method to get data by name
    @Query("select s from Student s where s.name = ?1")      // ? will be replaced by argument of method

    //this method is already created by DSL, So i dont really need to put the @Query here, it will do that automatically
    //but for other name i need to pute Query tags here
    List<Student> findByName(String name);


    //this Query is also created by DSL
    List<Student> findByMarksGreaterThan(int marks);
}
