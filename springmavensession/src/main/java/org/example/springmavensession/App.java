package org.example.springmavensession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String args[]) {
        System.out.println("main class here");

        Car c1 = new Car();
        c1.drive();

        Vehicle v1 = new Bike();
        v1.drive();

        // xml bean based
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Vehicle vech = (Vehicle)context.getBean("vehicle");
        vech.drive();

        // annotation based
        Vehicle vech2 = (Vehicle)context.getBean("car");
        vech2.drive();

        Tyre tyr = (Tyre)context.getBean("tyre");
        System.out.println(tyr);
    }
}
