package com.satyam;

public class Laptop {

    private int a;
    private String st;

    public Laptop(){
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
}
