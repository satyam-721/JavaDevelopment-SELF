package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ChangingNames {
    public static void main(String[] args) {
        Programmers p = new Programmers();
        p.setId(1);
        p.setName("satyam");
        p.setEmail("satyam@example.com");

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Programmers.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tr = session.beginTransaction();

        session.persist(p);

        tr.commit();
        session.close();
        sf.close();



    }

}
