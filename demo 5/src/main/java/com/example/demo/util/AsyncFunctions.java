package com.example.demo.util;

import com.example.demo.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class AsyncFunctions {

    @Autowired
    RestTemplate restTemplate;

    @Async
    public void runWithAsync(Integer num) {
        String apiUrl = "http://localhost:8080/persons";
        System.out.println(num);

        try {
            Thread.sleep(1000);

        } catch(InterruptedException ex) {

        }
        ResponseEntity<List<PersonEntity>> getCallResponse =
                restTemplate.exchange(apiUrl, HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<PersonEntity>>() {
                        });
        System.out.println(num);
        getCallResponse.getBody().forEach(eachPerson -> System.out.println(eachPerson.getName()));
    }

}
