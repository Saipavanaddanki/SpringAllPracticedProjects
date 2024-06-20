package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	ServiceImp service;
	
	@Autowired
	PaymentApiFeignClient paymentFeignClient;
	
	@GetMapping(path="/mobile/booking")
	public ResponseEntity<String> booking(@RequestBody MobileStoreDto mobile){
		return new ResponseEntity<String>(service.booking(mobile),HttpStatusCode.valueOf(201));
	}
	
	@GetMapping(path="/mobile/details/{id}")
	public ResponseEntity<MobileStore> gettingMobileDetails(@PathVariable int id){
		return new ResponseEntity<MobileStore>(service.bookingDetails(id),HttpStatusCode.valueOf(200));
	}
	
	@PostMapping(path="/payment")
	public String gettingPayment(@RequestBody PaymentDto payment) {
		System.out.println(paymentFeignClient.getClass());
		return paymentFeignClient.gettingPaymentStatus(payment, "SBI").getBody();
	}
}
