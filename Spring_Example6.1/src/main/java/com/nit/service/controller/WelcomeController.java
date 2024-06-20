package com.nit.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.service.Orders;
import com.nit.service.OrdersDto;
import com.nit.service.db.ServiceImp;

@RestController
public class WelcomeController {

	@Autowired
	ServiceImp service;
	@PostMapping(value="/booking")
	public ResponseEntity<String> toInsert(@RequestBody OrdersDto order){
		
		return new ResponseEntity<String>(service.insert(order),HttpStatusCode.valueOf(200));
	}
	
	@PostMapping(path="/viewAllOrders",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Orders>> view(){
     System.out.println(service.viewAll().toString());
		return new ResponseEntity<List<Orders>>(service.viewAll(),HttpStatusCode.valueOf(200));
	}
}
