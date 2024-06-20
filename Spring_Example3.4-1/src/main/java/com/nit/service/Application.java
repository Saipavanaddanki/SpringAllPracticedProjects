package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean("Db")
	public UserService getDb() {
		return new UserService();
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext container=SpringApplication.run(Application.class, args);
		UserService db=container.getBean(UserService.class);
		db.insert(1, "sai", 3000.22);
		db.insert(2, "pavan", 5000.78);
		db.select();
	}

}
