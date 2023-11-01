package com.it.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class CarServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CarServiceApplication.class, args);
	}
	
}
