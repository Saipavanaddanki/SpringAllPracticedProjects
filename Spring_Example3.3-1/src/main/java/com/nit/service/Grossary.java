package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Groosary_Details")
public class Grossary {

	@Id
	private int orderId;
	private String[]  Items;
	private double finalCost;
}
