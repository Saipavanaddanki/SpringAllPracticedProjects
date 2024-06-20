package com.nit.service;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="products_Order_Details")
@Data
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productAutoId;
	private String productId;
	private String productName;
	private  double productPrice;
	private int productQuantity;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="orderId_productID")
	private Orders orders;
}
