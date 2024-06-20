package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class UserGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserGatewayApplication.class, args);
	}

}
