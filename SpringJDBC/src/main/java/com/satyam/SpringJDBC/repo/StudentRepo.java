package com.satyam.SpringJDBC.repo;

import com.satyam.SpringJDBC.model.Student;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;



    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql = "insert into student (name, marks, roll) values (?, ?, ?)";
        int rows = jdbc.update(sql,s.getName(),s.getMarks(),s.getRoll());  //executeUpdate
        System.out.println(rows + " effected");
    }

    public List<Student> findAll(Student s){
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s =new Student();
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                s.setRoll(rs.getInt("roll"));
                return s;
            }
        };
        String sql = "select * from student";
        return jdbc.query(sql,mapper);
    }
}
