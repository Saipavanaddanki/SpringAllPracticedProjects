package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ReactWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactWithSpringApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer configurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
			   //   registry.addMapping("/display").allowedOrigins("http://localhost:3000/");
				 registry.addMapping("/**").allowedOrigins("*");
				 //any request=*;
				 //to use multiple mappings we use **
			}
		};
	}

}
