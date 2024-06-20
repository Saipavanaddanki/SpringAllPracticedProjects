package com.nit.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan
public class ConfigurationClass {
    
	@Scope("prototype")
	@Bean
	public University getUniversity() {
		return new University();
	}
	@Bean
	public Student getStudent() {
		return new Student();
	}
	@Primary
	@Bean
	public Employee getEmployee() {
		return new Employee(200,"kalyan");
	}
	
}
