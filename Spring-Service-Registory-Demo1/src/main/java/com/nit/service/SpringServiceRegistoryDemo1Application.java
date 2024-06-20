package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringServiceRegistoryDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringServiceRegistoryDemo1Application.class, args);
	}

}
