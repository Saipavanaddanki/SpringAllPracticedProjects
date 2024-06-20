package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class productsDto {


	private int productId;
	private String name;
	private double price;
	 
}
