package com.nit.service;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringExample22Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container=SpringApplication.run(SpringExample22Application.class, args);
	    
	}

}
