package com.arpi.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

    public static void main(String[] args) {
        // Tell Spring Boot in one step to start the application,
        // create sublet(= servlet?) container
        // and host application there.

        // First arg is 'source' = class where you have your main method
        SpringApplication.run(CourseApiApp.class, args);
    }
}
