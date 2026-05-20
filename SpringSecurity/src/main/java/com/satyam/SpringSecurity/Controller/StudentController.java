package com.satyam.SpringSecurity.Controller;

import com.satyam.SpringSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(new Student(1,"satyam","java"),
          new Student(2,"sagar","python"),
          new Student(3,"prasad","C"),
          new Student(4,"raj","C++"),
          new Student(5,"satu","js")));

    @GetMapping("/students")
    public List<Student> getAllStudents(){
      return students;
    }


    @GetMapping("csrfToken")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    //post mapping requires csrf token as header
    /*csrf protection is bydefault enable in spring sequirty
    - every post,put,delete req from client required to send a csrf token as header
    - browser will not automatically send this like sessionID
    - csrf token is generated during authetication with session Id by the server
     */
    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

}
