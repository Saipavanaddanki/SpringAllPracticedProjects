package com.nit.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {
	RestTemplate template=new RestTemplate();
	@PostMapping(path="/Insert" ,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public String toInsert(@RequestBody GrossaryDto grossary) {
		MultiValueMap<String, String> map=new LinkedMultiValueMap<>();
		map.add("Sending_grossary_detailss", "HellotoInsertinDb");
		
		HttpEntity<GrossaryDto> request=new HttpEntity<GrossaryDto>(grossary,map);
		
		ResponseEntity<String> response=template.exchange("http://localhost:9999/grossary/Insert",HttpMethod.POST,request,String.class);
		return response.getBody();
	}
	
	@PostMapping(path="/Select/{id}")
	public ResponseEntity<Grossary> select(@PathVariable int id){
//	    Map<Integer ,Integer> map=new HashMap<>();
//		    map.put(001,90);
	        ResponseEntity<Grossary> response=template.exchange("http://localhost:9999/grossary/Select/{id}?para1={p1}", HttpMethod.POST,null,Grossary.class,id,30);
	       return new ResponseEntity<Grossary>(response.getBody(),response.getHeaders(),response.getStatusCode());
	        
	
	}
}
