package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ApplicationContext container=	SpringApplication.run(Application.class, args);
	UsersService db=container.getBean(UsersService.class);
//	db.select();
//	db.update(102,"sai");
//	db.select();
	//db.selectById(102);
	db.selectByFindByMethod2();
	}

}
