package com.nit.service;

import lombok.Data;

@Data
public class ProductsDto {
	private int id;
	private String description;
	private double price;
	private String category;
	private String image;
}
