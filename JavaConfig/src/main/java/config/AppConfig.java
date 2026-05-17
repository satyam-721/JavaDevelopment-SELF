package config;

import com.satyam.Employee;
import com.satyam.Laptop;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Configurable   //it means it is configuration class
public class AppConfig {

    @Bean      //specify it is bean
    //now spring will call this and create the object
    @Scope("prototype")
    public Employee employee(){   //by Default the name of bean is method name (employee)
        return new Employee();
    }

    //to add more name use arguments (name = {name1,name2...} or <name>) in annotation


    //Assignning a value
    @Bean
    @Scope("prototype")
    public Laptop laptop(){
        Laptop obj = new Laptop();
        obj.setA(12);
        return obj;
    }
}
