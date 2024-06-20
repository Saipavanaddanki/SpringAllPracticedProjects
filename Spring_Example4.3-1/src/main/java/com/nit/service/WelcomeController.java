package com.nit.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

	@GetMapping(value="/getting")
	public ResponseEntity<List<ProductsDto>> toDisplay(){
		//HttpEntity<List<ProductsDto>> request=new HttpEntity<List<ProductsDto>>(pro);
		ResponseEntity<List<ProductsDto>> response=new RestTemplate().getForEntity("https://fakestoreapi.com/products",null,List.class);
		
		return new ResponseEntity<List<ProductsDto>>(response.getBody(),HttpStatus.CREATED);
	}
}
