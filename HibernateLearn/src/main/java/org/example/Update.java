package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Update {
    public static void main(String[] args) {

        Student st =new Student();
        st.setName("satyam");
        st.setAge(22);
        st.setRollno(177);

        System.out.println(st);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.configure();

        SessionFactory sf =  cfg.buildSessionFactory();
        Session session =sf.openSession();

        Transaction transaction = session.beginTransaction();


        session.merge(st);    //update

        transaction.commit();


        session.close();
        sf.close();
    }
}
