package com.nit.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nit.service.ManyToOne.DbServices4;

@SpringBootApplication
public class SpringExample11Application {

	public static void main(String[] args) {
	BeanFactory container=SpringApplication.run(SpringExample11Application.class, args);
	DbServices4 db=container.getBean(DbServices4.class);
	db.insert();
	}

}
