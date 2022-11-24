package com.example.demo.service;

import com.example.demo.entity.PersonEntity;
import com.example.demo.respository.PersonJPARespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FirstService {

    @Autowired
    PersonJPARespository personJPARespository;


    @Autowired
    RestTemplate restTemplate;

    public List<PersonEntity> findAllData()  {

        
        
        return personJPARespository.findAll();
    }


    public int updateExistingPersonData(Integer age, String name)  {
        String apiUrl = "http://localhost:8080/persons";


        ResponseEntity<List<PersonEntity>> getCallResponse =
                restTemplate.exchange(apiUrl, HttpMethod.GET,
                null,
                        new ParameterizedTypeReference<List<PersonEntity>>() {
        });

        getCallResponse.getBody().forEach(eachPerson -> System.out.println(eachPerson.getName()));

        return personJPARespository.updateQueryExample(age, name);
    }

}
