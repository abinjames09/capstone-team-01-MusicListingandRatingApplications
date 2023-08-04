package com.example.manymanyrelation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double wheels;

    public Car(){}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

     

public Double getWheels() {
        return wheels;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWheels(Double wheels) {
        this.wheels = wheels;
    }

    public Car(Integer id, String name, Double wheels) {
        this.id = id;
        this.name = name;
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", name=" + name + ", wheels=" + wheels + "]";
    }

    
    
}
