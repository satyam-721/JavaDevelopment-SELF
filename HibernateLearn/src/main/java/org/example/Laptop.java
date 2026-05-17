package org.example;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

////Embeddable aloows to merge the content of this class to the referance class to make one table only
//@Embeddable



@Entity
public class Laptop {

    @Id
    private int lid;
    private String brand;
    private int price;
    private String model;

    /// ManyToOne
//    //this is foriegn key that link to Employee table
//    @ManyToOne    //from laptop pov
//    private Employees emp;

    /// ManyToMany
    @ManyToMany(mappedBy = "laptop")
    private List<Employees> emps;


    public List<Employees> getEmps() {
        return emps;
    }

    public void setEmps(List<Employees> emps) {
        this.emps = emps;
    }

    public String getBrand() {
        return brand;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", model='" + model + '\'' +
                '}';
    }
}
