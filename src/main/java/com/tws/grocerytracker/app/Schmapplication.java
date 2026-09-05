package com.tws.grocerytracker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.tws.grocerytracker.model")
@EnableJpaRepositories("com.tws.grocerytracker.repository")
public class Schmapplication {
    public static void main(String[] args) {
        SpringApplication.run(Schmapplication.class, args);
    }
}
