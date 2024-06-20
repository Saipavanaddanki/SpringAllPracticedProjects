package com.nit.service.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.service.ListOfProducts;
import com.nit.service.Orders;
import com.nit.service.OrdersDto;
import com.nit.service.Products;

@Service
public class ServiceImp implements Servicess{

	@Autowired
	OrderDb repository;
	@Override
	public String insert(OrdersDto order) {
		List<Products> list=new ArrayList<>();
		
	      order.getListOfProducts().forEach(x->{
	    	  Products product=new Products();
	    	  product.setName(x.getName());
	    	  product.setPrice(x.getPrice());
	    	  product.setProductId(x.getProductId());
	    	  list.add(product);
	      });
	      Orders orders=new Orders();
	      orders.setConfirmOrder(order.getConfirmOrder());
	      orders.setListOfProducts(list);
	      orders.setOrderId(order.getOrderId());
	      orders.setPayment(order.getPayment());
	      repository.save(orders);
		return "order is Successfully placed===>>your order id is :"+orders.getOrderId() ;
	}


	public List<Orders> viewAll() {
		List<Orders> list=repository.findAll();
	
		return list;
	}
	
}
