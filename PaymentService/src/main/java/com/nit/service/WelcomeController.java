package com.nit.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	ServiceImp service;
//	@Autowired
	//MobileStoreApiAccessThroughFeign feignclient;
	
	@GetMapping(path="/processpayment")
	public ResponseEntity<String> gettingPaymentStatus(@RequestBody PaymentDto payment ,@RequestParam String bank) {

		
		Random random=new Random();
		int id=0;
		for(int i=0;i<5;i++) {
			id+=random.nextInt(100, 10000);
		}
		
		payment.setPaymentId(id);
		payment.setPaymentViaBank(bank);
		payment.setStatus(true);
		return new ResponseEntity<String>(service.processingPayment(payment),HttpStatus.OK);
	}
	

}
