package com.example.demo;

public class Person {
    public Person() {

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    private String name;
    private int age;


    public int getAge() {
        return age;
    }
    public String getName(){
        return name;
    }
}
