package com.nit.service;

import lombok.Data;

@Data
public class Products {

	private int id;
	private String image;
	private String name;
	private int price;
	private String category;
	private Rating rating;
	private String description;
	private String title;
	
}
