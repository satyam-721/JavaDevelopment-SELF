package com.satyam;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Teacher implements School{
    @Override
    public void work() {
        System.out.println("teaching in school");
    }
}
