package com.satyam;

import org.springframework.stereotype.Component;

@Component
public class Education {

    private String name;
    School sch;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSch() {
        return sch;
    }

    public void setSch(School sch) {
        this.sch = sch;
    }

    public void getWork(){
        sch.work();
    }
}
