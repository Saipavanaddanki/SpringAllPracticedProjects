package com.nit.service;

import java.util.List;

import lombok.Data;

@Data
public class MarketingDto {

	private List<ProductsDto> products;
	private int limit;
	private int skip;
	private int total;
}
