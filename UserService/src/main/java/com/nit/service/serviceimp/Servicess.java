package com.nit.service.serviceimp;

import java.util.List;

import com.nit.service.dtoclasses.UserRegistrationDto;

public interface Servicess {

	List<UserRegistration> retriveAll();
	String createUser(UserRegistrationDto user);
	String login(UserRegistrationDto user);
}
