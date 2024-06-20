package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class WelcomeController {

	@Autowired
	Servicess1 service;
	
	@RequestMapping(value="/Insert",method=RequestMethod.POST)
	public String toInsert(@RequestBody GrossaryDto grossary,HttpServletRequest request) {
		String result=request.getHeader("sending_grossary_detailss");
		return service.insert(grossary)+"    "+"resultfrom request to reponse:"+result;
	}
	
	
	@PostMapping(value="/Select/{id}")
	public ResponseEntity<Grossary> selectById(@PathVariable int id,@RequestParam Integer para1){
		HttpHeaders header=new HttpHeaders();
		header.add("Getting_Result","As aXMl");
		System.out.println(para1.getClass());
		return new ResponseEntity<Grossary>(service.select(id),header,HttpStatusCode.valueOf(200));
	}
	
}
