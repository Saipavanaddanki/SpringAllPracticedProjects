package com.nit.service;

import java.util.List;

import lombok.Data;

@Data
public class OrdersDto {
	private String orderId;
	private List<ProductsDto> listOfProducts;
	private String confirmOrder;
	private String payment;
}
