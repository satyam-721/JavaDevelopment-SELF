package com.satyam.demo.repo;

import com.satyam.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {

    JdbcTemplate jdbc;

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student stu){

        String sql="insert into student (id, name, cgpa) values (?, ?, ?)";
        try {
            int rows = jdbc.update(sql, stu.getId(), stu.getName(), stu.getCgpa());
            System.out.println(rows + " executed");
        }
        catch (DuplicateKeyException e){
            System.out.println("Id is duplicate");
        }
    }
}
