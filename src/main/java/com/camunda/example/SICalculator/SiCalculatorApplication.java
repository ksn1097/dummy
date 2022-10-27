package com.camunda.example.SICalculator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableProcessApplication("camunda-app")
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "Examples",version = "1.0",description = "Examples samples"))
public class SiCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiCalculatorApplication.class, args);
	}

}
