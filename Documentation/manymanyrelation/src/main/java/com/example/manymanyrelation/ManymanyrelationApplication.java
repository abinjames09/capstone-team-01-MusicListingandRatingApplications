package com.example.manymanyrelation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ManymanyrelationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManymanyrelationApplication.class, args);

		System.out.println("Running");
	}

}
