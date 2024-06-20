package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.Data;

@Component
@Data
public class WelcomeController {
	
	mobiles mobile;
	@Autowired
	WelcomeController(@Qualifier("display") mobiles mobile){
		this.mobile=mobile;
	}

	@Value("${s.value:pavan}")
	  String value;
	@PostMapping(value="/display")
	public String display() {
		

		return "mobiles"+"  "+value;
	}
	
	
}
