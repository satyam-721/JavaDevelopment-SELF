package org.example;

import jakarta.persistence.*;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Employees {

    @Id
    private int id;
    private String name;
    private String email;

//    @OneToOne
//    private Laptop laptop;

    /// OneToMany
    //this will make a new table that link primary key of Employee and Laptop
//    @OneToMany  //add mappedBy to avoide creating table (mappedBy = "emp")
//    private List<Laptop> laptop;

    /// ManyToMany   //there is a fetch method use to change lazy,eager fetch
    @ManyToMany
    private List<Laptop> laptop;

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", laptop=" + laptop +
                '}';
    }

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

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
