package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SpringExampleDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleDemo1Application.class, args);
	}

}
