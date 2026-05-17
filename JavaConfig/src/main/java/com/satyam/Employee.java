package com.satyam;

public class Employee {

    private int age;

    public Employee(){
        System.out.println("Employee Constructor called");
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setter method called");
        this.age = age;
    }

    public void show(){
        System.out.println("Inside emp show method");
    }


}
