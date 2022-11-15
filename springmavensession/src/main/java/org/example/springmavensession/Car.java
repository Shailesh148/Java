package org.example.springmavensession;


import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

    @Override
    public void drive() {
        System.out.println("car ride");
    }
}
