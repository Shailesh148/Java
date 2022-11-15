package org.example.configurationsannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigration {
    public static void main(String args[]) {
        ApplicationContext anntContext = new AnnotationConfigApplicationContext(LaptopConfiguration.class);
        Laptop lap = anntContext.getBean(Laptop.class);
        lap.show();
    }
}
