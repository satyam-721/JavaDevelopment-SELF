package com.satyam.Jobapp.service;

import com.satyam.Jobapp.Repo.UserRepo;
import com.satyam.Jobapp.model.User;
import com.satyam.Jobapp.model.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
