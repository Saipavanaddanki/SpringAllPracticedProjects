package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringGateway3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringGateway3Application.class, args);
	}

}
