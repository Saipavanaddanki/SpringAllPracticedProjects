package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringExample25Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container=SpringApplication.run(SpringExample25Application.class, args);
		Order order=container.getBean(Order.class);
		order.getProduct();
	}

}
