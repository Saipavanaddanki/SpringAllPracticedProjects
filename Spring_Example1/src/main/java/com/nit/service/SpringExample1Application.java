package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringExample1Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext container=	SpringApplication.run(SpringExample1Application.class, args);
	DbOperations db=(DbOperations)container.getBean("dbOperations");
	db.insert();
	
	
	}

}
