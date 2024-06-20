package com.nit.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@PostMapping(value="/display",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductsDto>> display(@RequestBody ProductsListDto products) {
		return new  ResponseEntity<List<ProductsDto>>(products.getProducts(),HttpStatus.CREATED);
	}
}
