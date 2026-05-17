package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embeddables {
    public static void main(String[] args){

        Employees emp = new Employees();
        emp.setEmail("satyam@gmail.com");
        emp.setId(1);
        emp.setName("satyam");


        Laptop lap = new Laptop();
        lap.setBrand("Lenovo");
        lap.setModel("slim");
        lap.setPrice(50000);
//        emp.setLaptop(lap);


        System.out.println(emp);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Employees.class);
        cfg.configure();

        SessionFactory sf =  cfg.buildSessionFactory();
        Session session =sf.openSession();  //  can be used to create multiple session

        session.persist(emp);

        Transaction transaction = session.beginTransaction();
        transaction.commit();

        //displaying records

        Employees emp2 = session.find(Employees.class,1);


        session.close();
        sf.close();

    }
}
