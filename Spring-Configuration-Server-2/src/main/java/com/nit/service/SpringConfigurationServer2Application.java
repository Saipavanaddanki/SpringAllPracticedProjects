package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class SpringConfigurationServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigurationServer2Application.class, args);
	}

}
