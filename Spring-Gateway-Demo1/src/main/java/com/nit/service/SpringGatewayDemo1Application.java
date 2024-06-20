package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class SpringGatewayDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayDemo1Application.class, args);
	}

}
