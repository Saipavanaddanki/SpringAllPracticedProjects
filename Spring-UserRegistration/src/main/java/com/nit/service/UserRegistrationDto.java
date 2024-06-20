package com.nit.service;

import java.util.List;

import lombok.Data;

@Data
public class UserRegistrationDto {
	private int userId;
	private String userName;
	private double userSal;
	private List<AddressDto> address;
}
