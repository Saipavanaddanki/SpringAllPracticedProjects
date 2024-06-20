package com.nit.service;

import lombok.Data;

@Data
public class UserRegistrationDto {

	private int userId;
	private String userName;
	private String password;
	private String email;
}
