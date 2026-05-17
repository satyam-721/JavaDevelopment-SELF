package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Delete {
    public static void main(String[] args) {



        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.configure();

        SessionFactory sf =  cfg.buildSessionFactory();
        Session session =sf.openSession();

        Student s1= session.find(Student.class,177);

        Transaction transaction = session.beginTransaction();

        //This method need an object to delete .
        //if I have only primary key then i have to fetch the data then delete it
        session.remove(s1);    //delete

        transaction.commit();


        session.close();
        sf.close();
    }
}
