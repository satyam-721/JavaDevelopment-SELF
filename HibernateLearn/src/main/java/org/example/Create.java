package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Create {
    public static void main(String[] args) {

        Student st =new Student();
        st.setName("satyam");
        st.setAge(20);
        st.setRollno(176);

        System.out.println(st);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.configure();

        //It takes a lot of resource, so use only one in application
        SessionFactory sf =  cfg.buildSessionFactory();
        Session session =sf.openSession();  //  can be used to create multiple session

        session.persist(st);

        //After this a transaction has started commit it to save in db
        Transaction transaction = session.beginTransaction();
        transaction.commit();


        session.close();
        sf.close();
    }
}
