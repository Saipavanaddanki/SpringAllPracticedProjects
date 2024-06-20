package com.nit.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class WelcomeController {

	@PostMapping(value="/display",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MarketingDto> toDisplay( @RequestBody MarketingDto mk,HttpServletRequest request){
		 String header= request.getHeader("Headers");
		 System.out.println(header);
//		HttpEntity<> request=new HttpEntity<>();
//		RestTemplate template=new RestTemplate();
//		ResponseEntity<MarketingDto> response=template.getForEntity("https://dummyjson.com/products", null, MarketingDto.class);
//		response.getBody().getProducts().forEach(System.out::println);
		return new ResponseEntity<MarketingDto>(mk,HttpStatus.OK);
	}
}
