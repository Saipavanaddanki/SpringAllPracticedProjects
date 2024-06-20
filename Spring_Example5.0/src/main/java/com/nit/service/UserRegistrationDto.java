package com.nit.service;

import java.util.List;

import lombok.Data;

@Data
public class UserRegistrationDto {

	private String email;
	private String name;
	private Long mobile;
	private List<Addressess> address; 
	private String password;
}
