package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp  implements Services{

	@Autowired
	Repository1 repo;
	
	public List<LoginDto> select() {
		return repo.findAll();
	}
}
