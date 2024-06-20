package com.nit.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@PostMapping(value="/get")
	public ResponseEntity<List<ProductsDto>> toDisplay(@RequestBody List<ProductsDto> pro){
		
		return new ResponseEntity<List<ProductsDto>>(pro,HttpStatus.CREATED);
	}
}
