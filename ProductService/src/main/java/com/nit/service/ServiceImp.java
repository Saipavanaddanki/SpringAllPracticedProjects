package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceImp implements Servicess {
	
	@Autowired
	OrderRepository repository;

	@Override
	public List<Orders> viewAllOrders() {
		
		return repository.findAll();
	}

}
