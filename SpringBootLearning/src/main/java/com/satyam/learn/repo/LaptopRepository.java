package com.satyam.learn.repo;

import com.satyam.learn.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository  //works same as component but for repo
public class LaptopRepository {

    public void save(Laptop lap){
        System.out.println("Save into DB");
    }

}
