package com.satyam.SpringSecurity.Controller;


import com.satyam.SpringSecurity.model.User;
import com.satyam.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public User saveUser(@RequestBody User user){

        return service.saveUser(user);
    }

    @GetMapping("/me")
    public String currentUser(){
        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();

        return auth.getName();
    }
}
