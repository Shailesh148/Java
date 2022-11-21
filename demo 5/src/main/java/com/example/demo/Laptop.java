package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Laptop {

    String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void print() {
        System.out.println("laptop class here ");
    }
}
