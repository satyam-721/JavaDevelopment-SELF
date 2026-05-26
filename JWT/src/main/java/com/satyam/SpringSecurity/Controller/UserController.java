package com.satyam.SpringSecurity.Controller;


import com.satyam.SpringSecurity.model.User;
import com.satyam.SpringSecurity.service.JwtService;
import com.satyam.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @PostMapping("/register")
    public User saveUser(@RequestBody User user){
        user.setRole("USER");
        return service.saveUser(user);
    }

    @GetMapping("/me")
    public String currentUser(){
        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();

        return auth.getName();
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        user.setRole("DEMO");

        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        user.getUsername(),user.getPassword()
                ));

        /**
         * AuthenticationManager
         *         ↓
         * AuthenticationProvider
         *         ↓
         * UserDetailsService
         *         ↓
         * PasswordEncoder
         */
        if(auth.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "Failed";
    }
}
