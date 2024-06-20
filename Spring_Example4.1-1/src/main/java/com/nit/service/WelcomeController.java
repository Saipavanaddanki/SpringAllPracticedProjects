package com.nit.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {
	
	@PostMapping(value="/display")
	public ResponseEntity<MarketingDto> display(@RequestBody MarketingDto mk){
		MultiValueMap<String, String> headers=new LinkedMultiValueMap<>();
		headers.add("Headers", "Access");
		HttpEntity<MarketingDto> request=new HttpEntity<MarketingDto>(mk,headers);
		RestTemplate template=new RestTemplate();
		ResponseEntity<MarketingDto> response=template.postForEntity("http://localhost:9999/products/display", request, MarketingDto.class);
		return new ResponseEntity<MarketingDto>(response.getBody(),response.getStatusCode());
	}
}
