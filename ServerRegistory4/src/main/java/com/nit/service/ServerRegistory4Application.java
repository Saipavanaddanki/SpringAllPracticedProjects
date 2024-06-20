package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class ServerRegistory4Application {

	public static void main(String[] args) {
		SpringApplication.run(ServerRegistory4Application.class, args);
	}

}
