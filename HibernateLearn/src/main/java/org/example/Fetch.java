package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
    public static void main(String[] args){
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.configure();

        SessionFactory sf =cfg.buildSessionFactory();

        Session session =sf.openSession();

        Student s2 = session.find(Student.class,172);  //(return type,primary key)

        System.out.println(s2);
    }
}
