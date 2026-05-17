package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQL {
    public static void main(String[] args){


        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Users.class);
        cfg.configure();

        SessionFactory sf =  cfg.buildSessionFactory();
        Session session =sf.openSession();

//        var sql=session.createSelectionQuery("from Users where lid=2", Users.class);
        Query<Users> sql=session.createQuery("from Users where lid=2", Users.class);

        List<Users> users = sql.getResultList();

//        Users us = session.find(Users.class,2);

        System.out.println(users);

        session.close();
        sf.close();

    }
}
