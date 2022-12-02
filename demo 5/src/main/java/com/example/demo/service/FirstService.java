package com.example.demo.service;

import com.example.demo.entity.PersonEntity;
import com.example.demo.respository.PersonJPARespository;
import com.example.demo.util.AsyncFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FirstService {

    @Autowired
    AsyncFunctions asyncFunctions;

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


    @Cacheable(value="personDetailsCache")
    public List<PersonEntity> findByNameContainsAsynchronous(String name)  {

//        asyncFunctions.runWithAsync(1);
//        asyncFunctions.runWithAsync(2);

        System.out.println("fetching details from repo for name " + name);
        return personJPARespository.findByNameContains(name);
    }


    @CacheEvict(value="personDetailsCache", allEntries = true)
    @Scheduled(cron ="0 */1 * ? * *")
    public void evictCache() {
        System.out.println("evicting cache here");
    }


    public List<PersonEntity> completableFutureAsync(String name) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello Async");

        // supplier doesnt take any argument but returns a value

        // additional processes

        try {
            String data = future.get();
            System.out.println(data);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return personJPARespository.findByNameContains(name);

    }


    public List<PersonEntity> completableFutureAsyncThenApply(String name) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello Async");


        CompletableFuture<String> thenApplyFuture = future.thenApply(s -> s + "World");
        // supplier doesnt take any argument but returns a value

        // additional processes

        try {
            String data = thenApplyFuture.get();
            System.out.println(data);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return personJPARespository.findByNameContains(name);

    }


    public List<PersonEntity> completableFutureAsyncThenCompose(String name) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello Async")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "World"));

        // supplier doesnt take any argument but returns a value

        // additional processes

        try {
            String data = future.get();
            System.out.println(data);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return personJPARespository.findByNameContains(name);

    }


    public List<PersonEntity> completableFutureAsyncCombineFuture(String name) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello Async");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Here");


        // supplier doesnt take any argument but returns a value

        // additional processes

        String combinedResult = Stream.of(future1,future2,future3).map(CompletableFuture::join).collect(Collectors.joining(""));

        System.out.println(combinedResult);


        // reactive programming in java
        //

        return personJPARespository.findByNameContains(name);

    }

    // completableFuture handle errors
    public List<PersonEntity> futureHandleErrors(String mentorName) {
        String name = null;

        CompletableFuture<String> completableFuture
                =  CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
        try {
            String result = completableFuture.get();
            System.out.println(result);
        }catch (ExecutionException | InterruptedException ex){

        }

        List<String> str = new ArrayList<>(Arrays.asList("a","b","c"));
//        str.parallelStream().

        return personJPARespository.findByNameContains(mentorName);
    }





}
