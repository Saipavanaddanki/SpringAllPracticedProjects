package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbOperations {

	@Autowired
	Repository1 repository;
	 public void insert() {
		 List<Address> list=repository.findAll();
		 list.forEach(System.out::println);
		 
	 }
}
