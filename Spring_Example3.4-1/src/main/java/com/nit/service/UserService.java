package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

	@Autowired
	Repository1 repo;
	  
	public void insert(int id,String name,Double sal) {
		
		repo.insert(id,sal,name);
	}
	public void select() {
		repo.select().forEach(System.out::println);
	}
}
