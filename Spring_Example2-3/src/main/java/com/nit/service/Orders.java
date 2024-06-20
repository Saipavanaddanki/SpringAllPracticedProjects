package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Order_details")
public class Orders {

	@Id
	private String orderId;
	private String data;
}
