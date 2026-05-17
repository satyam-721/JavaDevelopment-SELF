package com.satyam.learn.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component     //add this so this object can store in container
public class Employee {
    @Value("23")
    private int id;
    private String name;
    private String email;

    @Autowired    //allow this to wire to laptop class and actually execute this
    Laptop lap;

    @Autowired
    @Qualifier("laptop")
    Computer com;

    public void code(){
        lap.compile();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void doWork(){
        com.work();
    }
}
