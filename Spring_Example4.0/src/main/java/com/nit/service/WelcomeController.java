package com.nit.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

//	@PostMapping(path="/display",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	public String  toDisplay(@RequestBody MarketingDto mk){
//		RestTemplate rest=new RestTemplate();
//		ResponseEntity<List> response=rest.exchange("https://dummyjson.com/products",HttpMethod.GET,null,List.class);
//		System.out.println(response.getBody());
//		return "success";
//	}
	 
	@PostMapping(path="/view")
	public ResponseEntity<List<ProductsDto>> display(@RequestBody MarketingDto mk){
		RestTemplate rest=new RestTemplate();
		System.out.println("********");
		HttpEntity<MarketingDto> request=new HttpEntity<MarketingDto>(mk);
		ResponseEntity<List> response=rest.postForEntity("http://localhost:8888/delivery/display", request, List.class);
		//to handle list of items we have to configure or reponseentity in a list of object only;
		System.out.println("********2");
	
		return new ResponseEntity<List<ProductsDto>>  (response.getBody(),HttpStatus.OK);
		
	}
}
