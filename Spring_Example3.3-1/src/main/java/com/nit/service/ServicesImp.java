package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesImp  implements Servicess1{

	
	@Autowired
	Repository1 repo;
	
	@Override
	public Grossary select(int id) {
		
		Optional<Grossary>  op=Optional.of(repo.findById(id).get());
		return op.get();
	}

	@Override
	public String insert(GrossaryDto grossary) {
		Grossary g=new Grossary();
		g.setOrderId(grossary.getOrderId());
		g.setItems(grossary.getItems());
		g.setFinalCost(grossary.getFinalCost());
		repo.save(g);
		
		return "Inserted Successfully";
	}

	
}
