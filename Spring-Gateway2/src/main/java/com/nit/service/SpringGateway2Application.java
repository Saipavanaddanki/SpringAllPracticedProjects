package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringGateway2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringGateway2Application.class, args);
	}

}
