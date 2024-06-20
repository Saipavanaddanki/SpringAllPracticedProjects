package com.nit.service;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class OrdersDto{
	private String orderId;
	private List<productsDto> listOfProducts;
	private String confirmOrder;
	private String payment;
	
}
