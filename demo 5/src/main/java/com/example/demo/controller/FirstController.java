package com.example.demo.controller;


import com.example.demo.Person;
import com.example.demo.entity.PersonEntity;
import com.example.demo.exception.CustonException;
import com.example.demo.respository.PersonJPARespository;
import com.example.demo.service.FirstService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    Logger logger = LoggerFactory.getLogger(FirstController.class);

    @Value("${userpath.value}")
    String userPath;

    @Autowired
    FirstService firstService;

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
        List<PersonEntity> personsList = firstService.findAllData();

        PersonEntity personEntity = PersonEntity
                .builder()
                .age(12)
                .name("R")
                .build();
        System.out.println(personEntity);
        logger.info(personEntity.toString());
        logger.info(userPath);

//        throw new CustonException("null pointer exception captured");
//        throw new NullPointerException("null pointer exception captured");
//        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        System.out.println("before giving response");
        return new ResponseEntity<>(personsList, HttpStatus.OK);
    }

    @GetMapping("/{person_name}")
    public ResponseEntity<List<PersonEntity>> getPersonDetails(@PathVariable String person_name) {

//        Person p1 = new Person("Shailesh", 27);
//        Person p2 = new Person("Utsav", 25);
//        Person p3 = new Person("Ayush", 35);
//        Person p4 = new Person("Ramesh", 27);
//        Person p5 = new Person("Adhip", 26);
//
//
//        List<Person> personsList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
//        List<Person> resultingList = personsList.stream().filter(p -> p.getName().equals(person_name)).collect(Collectors.toList());
        List<PersonEntity> personsList = firstService.findByNameContainsAsynchronous(person_name);


        return new ResponseEntity<>(personsList, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Integer> getPersonDetails(@RequestBody Person person) {

//        Person p1 = new Person("Shailesh", 27);.
//        Person p2 = new Person("Utsav", 25);
//        Person p3 = new Person("Ayush", 35);
//        Person p4 = new Person("Ramesh", 27);
//        Person p5 = new Person("Adhip", 26);
//
//
//        List<Person> personsList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
//
//        personsList.add(person);

        int result = firstService.updateExistingPersonData(person.getAge(), person.getName());
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

//    localhost://8080/persons?age=
//    @GetMapping()
//    public ResponseEntity<List<Person>> getPersonDetailsByAge(@RequestParam Integer age) {
//
//        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
//
//    }



    // add a person,
    // use findByAge from repository


}
