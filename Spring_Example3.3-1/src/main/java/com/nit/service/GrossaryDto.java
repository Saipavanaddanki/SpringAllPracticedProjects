package com.nit.service;

import lombok.Data;

@Data
public class GrossaryDto {
	private int orderId;
	private String[]  Items;
	private double finalCost;
}
