package com.example.demo.controller;


import com.example.demo.Person;
import com.example.demo.entity.PersonEntity;
import com.example.demo.respository.PersonJPARespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller()
@RequestMapping("/persons")
public class FirstController {

    @Autowired
    PersonJPARespository personJPARespository;

    @GetMapping()
    public ResponseEntity<List<PersonEntity>> getAllPerson() {

//        Person p1 = new Person("Shailesh", 27);
//        Person p2 = new Person("Utsav", 25);
//        Person p3 = new Person("Ayush", 35);
//        Person p4 = new Person("Ramesh", 27);
//        Person p5 = new Person("Adhip", 26);
//
//
//        List<Person> personsList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
        List<PersonEntity> personsList = personJPARespository.findAll();
        return new ResponseEntity<>(personsList, HttpStatus.OK);
    }

    @GetMapping("/{person_name}")
    public ResponseEntity<List<Person>> getPersonDetails(@PathVariable String person_name) {

        Person p1 = new Person("Shailesh", 27);
        Person p2 = new Person("Utsav", 25);
        Person p3 = new Person("Ayush", 35);
        Person p4 = new Person("Ramesh", 27);
        Person p5 = new Person("Adhip", 26);


        List<Person> personsList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
        List<Person> resultingList = personsList.stream().filter(p -> p.getName().equals(person_name)).collect(Collectors.toList());
        return new ResponseEntity<>(resultingList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<List<Person>> getPersonDetails(@RequestBody Person person) {
        Person p1 = new Person("Shailesh", 27);
        Person p2 = new Person("Utsav", 25);
        Person p3 = new Person("Ayush", 35);
        Person p4 = new Person("Ramesh", 27);
        Person p5 = new Person("Adhip", 26);


        List<Person> personsList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));

        personsList.add(person);
        return new ResponseEntity<>(personsList, HttpStatus.OK);

    }

    // edit a person, using requestparam
}
