package com.nit.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("PaymentService")
public interface PaymentApiFeignClient {
     
	@GetMapping(path="/processpayment")
	public ResponseEntity<String> gettingPaymentStatus(@RequestBody PaymentDto payment ,@RequestParam String bank); 
}

