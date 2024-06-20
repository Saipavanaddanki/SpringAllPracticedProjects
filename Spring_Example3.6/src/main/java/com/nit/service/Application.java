package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	public mobiles display() {
		mobiles n=new mobiles();
		n.setMid(200);
		n.setMname("karban");
		return n;
	}
	public static void main(String[] args) {
		ApplicationContext container=SpringApplication.run(Application.class, args);
		System.out.println(container.getBean(WelcomeController.class).getMobile().toString());
	}

}
