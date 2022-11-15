package org.example.configurationsannotation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.configurationsannotation")
public class LaptopConfiguration {

//    @Bean
//    public Keyboard getKeyboard() {
//        return new NormalKeyboard();
//    }
//
//    @Bean
//    public Laptop getLaptop() {
//        return new Laptop();
//    }
}
