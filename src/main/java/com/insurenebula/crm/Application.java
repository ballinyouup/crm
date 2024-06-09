package com.insurenebula.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        // Set environment variables
        System.setProperty("SPRING_DATASOURCE_URL", dotenv.get("DATABASE_URL"));
        System.setProperty("SPRING_DATASOURCE_USERNAME", dotenv.get("DATABASE_USERNAME"));
        System.setProperty("SPRING_DATASOURCE_PASSWORD", dotenv.get("DATABASE_PASSWORD"));

        SpringApplication.run(Application.class, args);
    }

}
