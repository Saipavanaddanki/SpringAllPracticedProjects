package com.nit.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductsDto {


	private String productId;
	private double productPrice;
	
	private String productName;
	private int productQuantity;
	
}
