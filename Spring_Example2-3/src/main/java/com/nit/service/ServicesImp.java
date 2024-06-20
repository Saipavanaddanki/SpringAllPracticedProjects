package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public non-sealed class ServicesImp implements Services {

	@Autowired
	Respository1 repository;
	
	@Override
	public int insertDataToDb(ProductsDto product,Orders order) {
		Products pro=new Products();
		pro.setProductId(product.getProductId());
		pro.setProductName(product.getProductName());
		pro.setProductPrice(product.getProductPrice());
		pro.setProductQuantity(product.getProductQuantity());
		pro.setOrders(order);
		repository.save(pro);
		return 1;
	}

}
