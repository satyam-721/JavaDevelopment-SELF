package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ManyToMany {
    public static void main(String[] args){

        Employees emp = new Employees();
        emp.setEmail("satyam@gmail.com");
        emp.setId(1);
        emp.setName("satyam");

        Employees emp2 = new Employees();
        emp2.setEmail("sagar@gmail.com");
        emp2.setId(2);
        emp2.setName("sagar");



        Laptop lap = new Laptop();
        lap.setLid(1);
        lap.setBrand("Lenovo");
        lap.setModel("slim");
        lap.setPrice(50000);

        Laptop lap2 = new Laptop();
        lap2.setLid(2);
        lap2.setBrand("Asus");
        lap2.setModel("vivobook");
        lap2.setPrice(28000);

        emp.setLaptop(Arrays.asList(lap,lap2));
        emp2.setLaptop(Arrays.asList(lap,lap2));

        lap.setEmps(Arrays.asList(emp,emp2));
        lap2.setEmps(Arrays.asList(emp));




        System.out.println(lap.getEmps());

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Employees.class);
        cfg.addAnnotatedClass(org.example.Laptop.class);
        cfg.configure();

        SessionFactory sf =  cfg.buildSessionFactory();
        Session session =sf.openSession();  //  can be used to create multiple session

        session.persist(emp);
        session.persist(emp2);
        session.persist(lap);
        session.persist(lap2);

        Transaction transaction = session.beginTransaction();
        transaction.commit();

        //displaying records

        Laptop empfetch = session.find(Laptop.class,1);
        System.out.println(empfetch);

        session.close();
        sf.close();

    }
}
