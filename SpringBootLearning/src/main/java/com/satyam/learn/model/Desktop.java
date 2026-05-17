package com.satyam.learn.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer{

    public void work(){
        System.out.println("Working in Desktop");
    }

}
