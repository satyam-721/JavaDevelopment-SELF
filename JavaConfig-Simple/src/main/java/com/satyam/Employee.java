package com.satyam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    private int age;

    @Autowired    //search on container for this object
    Laptop lap;

    Employee(){
        System.out.println("Constructor called");
    }

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        this.lap = lap;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setter method called");
        this.age = age;
    }

    public void work(){
        System.out.println("Working...");
        lap.code();
    }

}
