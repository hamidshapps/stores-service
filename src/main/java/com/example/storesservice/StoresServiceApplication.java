package com.example.storesservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class StoresServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoresServiceApplication.class, args);
    }
}
