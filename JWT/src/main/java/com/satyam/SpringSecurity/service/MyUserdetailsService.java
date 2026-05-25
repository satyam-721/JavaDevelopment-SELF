package com.satyam.SpringSecurity.service;

import com.satyam.SpringSecurity.dao.UserRepo;
import com.satyam.SpringSecurity.model.User;
import com.satyam.SpringSecurity.model.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserdetailsService implements UserDetailsService {


    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);


        if (user == null){
            System.out.println("404: "+username+" Not found");
            throw new UsernameNotFoundException("404: Username Not found");
        }

        //wrapping user into UserDetails
        return new UserDetailsImp(user);
    }
}
