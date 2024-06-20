package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class serviceImp  implements Servicess {

	
	@Autowired
	Repository1 repo;
	public String insert(Register reg) {
	
		repo.save(reg);
		System.out.println("inserted successfull");
		return "inserted successfull";
	}
	@Override
	public List<Register> select() {
		
		return repo.findAll();
	}
}
