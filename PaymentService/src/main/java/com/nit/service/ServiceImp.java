package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp {

	@Autowired
	PaymentDb payment;
	
	public String  processingPayment(PaymentDto pay) {
		Payment process=new Payment();
		process.setAmount(pay.getAmount());
		process.setPaymentId(pay.getPaymentId());
		process.setPaymentViaBank(pay.getPaymentViaBank());
		process.setStatus(pay.isStatus());
		payment.save(process);
		return  "Payment Successfull";
	}
}
