package com.nit.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class WelcomeController {

	@Autowired
	private Services service;
   
	@GetMapping(path="/order/{customerName}",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public String toPlaceOrder(@PathVariable String customerName,@Valid @RequestBody ProductsDto product) {
		Orders order=new Orders();
		order.setOrderId(customerName+String.valueOf((int)Math.floor(Math.random()*1000)));
		System.out.println("OrderId:  "+order.getOrderId()+"   is generated");
		order.setData(new Date().toString());
		int i=service.insertDataToDb(product, order);
		if(i>0) {
		return "Your Order Confirmation  OrderId :"+order.getOrderId()+"  Date Of OrderPlaced : " +order.getData() +"  order is placed successfully ";
		}else {
			return "Error occured in Order Booking please try After some time";
		}
	}
	
}
