package com.nit.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("USERSDETAILS")
public interface UserFeignClient {
	@GetMapping(value="userDetails/finding/record/{userid}")
	public UserDetailsDto FindById(@PathVariable int userid);
	
	@GetMapping(path="userDetails/create/retrive")
	public String insertAndRetrive(@RequestBody UserDetailsDto user) ;
}
