package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableCaching
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		Laptop lpt = (Laptop)ctx.getBean("laptop");
		lpt.print();

		// avoid verbs, use nouns

		// SOLID

//      Single Responsibility
//		Open/Closed => Open for extension, closed for modification
//		Liskov Substitution
		//		public interface Car {
//
//			void turnOnEngine();
//			void accelerate();
//		}

//		public class MotorCar implements Car {
//
//			private Engine engine;
//
//			//Constructors, getters + setters
//
//			public void turnOnEngine() {
//				//turn on the engine!
//				engine.on();
//			}
//
//			public void accelerate() {
//				//move forward!
//				engine.powerOn(1000);
//			}
//		}
//		public class ElectricCar implements Car {
//
//			public void turnOnEngine() {
//				throw new AssertionError("I don't have an engine!");
//			}
//
//			public void accelerate() {
//				//this acceleration is crazy!
//			}
//		}


//		Interface Segregation =>
//		public interface Human {
//			countHand();
//		}
//
//		public interface Eating {
//			eatingHuman();
//		}
//		public interface Driving {
//			drivingHuman();
 //		}

//		Dependency Inversion



		// docker download
		// add docker file to this application
		// create a docker container


	}

}
