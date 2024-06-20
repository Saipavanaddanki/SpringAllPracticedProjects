package com.nit.service.dtoclasses;

import java.util.List;

import lombok.Data;

@Data
public class UserRegistrationDto {
	private String email;
	private String name;
	private long mobile;
	private String password;
	private List<AddressessDto> address;
}
