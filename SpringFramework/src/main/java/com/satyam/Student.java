package com.satyam;

public class Student implements School {

    private int rollno;
    private String name;

    @Override
    public void work(){
        System.out.println("Studying in school");
    }

}
