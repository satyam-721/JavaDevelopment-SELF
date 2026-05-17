package com.satyam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    @Value("21")
    private int a;
    private String st;

    @Autowired    //it is prefered to write in setter if have one
    @Qualifier("student")  //by default bean name is class name with 1st char small
    School sch;

    Laptop(){
        System.out.println("Laptop Constructor called");
    }
    Laptop(int a){
        System.out.println("one parameterized called");
        this.a = a;
    }
    Laptop(int a,String st){
        System.out.println("Two parameterized Cons called");
        this.st = st;
        this.a = a;
    }


    void code(){
        System.out.println("Compiling....");
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public void giveLaptop(){
        sch.work();
    }
}
