package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class OneToMany {
    public static void main(String[] args){

        Employees emp = new Employees();
        emp.setEmail("satyam@gmail.com");
        emp.setId(1);
        emp.setName("satyam");


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

        //Emp here is forien key in laptop
//        lap.setEmp(emp);
//        lap2.setEmp(emp);


        System.out.println(emp);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Employees.class);
        cfg.addAnnotatedClass(org.example.Laptop.class);
        cfg.configure();

        SessionFactory sf =  cfg.buildSessionFactory();
        Session session =sf.openSession();  //  can be used to create multiple session

        session.persist(emp);
        session.persist(lap);
        session.persist(lap2);

        Transaction transaction = session.beginTransaction();
        transaction.commit();

        //displaying records

        Employees emp2 = session.find(Employees.class,1);


        session.close();
        sf.close();

    }
}
