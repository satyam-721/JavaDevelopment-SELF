package com.satyam.learn.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    public void compile() {
        System.out.println("Compiling in laptop....");
    }

    public void work(){
        System.out.println("Working in Laptop");
    }
}
