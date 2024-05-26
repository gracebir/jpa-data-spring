package com.grace.jpa_data_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDataSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDataSpringApplication.class, args);
		System.out.println("Yes, the application is working");
	}

}
