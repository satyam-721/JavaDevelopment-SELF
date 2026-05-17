package org.example;

import jakarta.persistence.*;

@Entity
@Table(name="Software_dev")    //this will change the table name
public class Programmers {

    @Id
    private int id;

    @Column(name="user_name")    //to map different column name
    private String name;

    @Transient                     //this column will not be saved in database
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
