package com.satyam;

public class Teacher implements School{
    @Override
    public void work() {
        System.out.println("teaching in school");
    }
}
