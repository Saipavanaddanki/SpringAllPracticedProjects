
package com.nit.service;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

	@GetMapping(value="/Api1",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Products>> fetchingApiFakeStore(){
		RestTemplate template=new RestTemplate();
		ResponseEntity<List> response=template.exchange("https://fakestoreapi.com/products", HttpMethod.GET, null, List.class);
		return new ResponseEntity<List<Products>>(response.getBody(),HttpStatusCode.valueOf(200));
	}
	
	@GetMapping(value="/Api2",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Photos> fetchingApiNasa(){
		RestTemplate template=new RestTemplate();
		ResponseEntity<Photos> response=template.exchange("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY", HttpMethod.GET,null,Photos.class);
		return new ResponseEntity<Photos>(response.getBody(),HttpStatusCode.valueOf(200));
	}
}
