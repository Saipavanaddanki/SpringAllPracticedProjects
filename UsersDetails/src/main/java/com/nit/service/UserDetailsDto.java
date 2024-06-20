package com.nit.service;

import lombok.Data;

@Data
public class UserDetailsDto {

	private int userId;
	private String userName;
	private String password;
	private long mobile;
	private String email;
}
