package com.nit.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

	@PostMapping(value="/api")
	public Joke display(){
		ResponseEntity<Joke> response=new RestTemplate().getForEntity("https://official-joke-api.appspot.com/random_joke", null,Joke.class );
		System.out.println(response.getBody());
		return response.getBody();
	}
}
