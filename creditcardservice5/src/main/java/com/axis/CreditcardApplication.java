package com.axis;

//import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;



@EnableEurekaClient
@SpringBootApplication
public class CreditcardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditcardApplication.class, args);
	}
	/*
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();*/

}

