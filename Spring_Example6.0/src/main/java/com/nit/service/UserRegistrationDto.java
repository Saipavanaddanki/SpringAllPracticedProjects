package com.nit.service;

import java.util.List;

import lombok.Data;

@Data
public class UserRegistrationDto {
 private String email;
 private String name;
 private String password;
 private long mobile;
 private List<AddressessDto> address;
}
