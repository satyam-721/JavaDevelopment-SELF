package com.satyam.learn.service;

import com.satyam.learn.repo.LaptopRepository;
import com.satyam.learn.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   //work same as component but for services
public class LaptopService {

    @Autowired
    LaptopRepository repo;

    public void addLaptop(Laptop lap) {
        System.out.println("Laptop Service ");

        //save(); calls to repository inorder to save into db

        repo.save(lap);
    }
}
