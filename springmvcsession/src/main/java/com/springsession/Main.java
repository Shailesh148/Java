package com.springsession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {

    @RequestMapping("/get")
    public void gatData() {
        System.out.println("getting data here");
    }
}
