package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringServiceRegistory2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringServiceRegistory2Application.class, args);
	}

}
