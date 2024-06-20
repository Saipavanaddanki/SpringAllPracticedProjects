package com.nit.service.db;

import com.nit.service.UserRegistration;
import com.nit.service.UserRegistrationDto;

public interface Servicess {

	UserRegistration insert(UserRegistrationDto user);
}
