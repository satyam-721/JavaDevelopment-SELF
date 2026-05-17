package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;




@Entity
public class Users {

    @Id
    private int lid;
    private String brand;
    private int price;
    private String model;



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
