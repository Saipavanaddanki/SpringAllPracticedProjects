package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Order {

	@Autowired
	Order(Products pro){
		product=pro;
	}
	
	private Products product ;
}
