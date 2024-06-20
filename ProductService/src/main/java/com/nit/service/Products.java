package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="products_Details")
public class Products {
	@Id
	private int productId;
	private String name;
	private double price;
}
