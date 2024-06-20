package com.nit.service;

import lombok.Data;

@Data
public class ProductsDto {

	private int id;
	private String title;
	private String description;
	private double price;
	private int rating;
	private int discountPercentage;
	private String brand;
	private int stock;
	private String category;
	private String thumbnail;
	private String[] images;
}
