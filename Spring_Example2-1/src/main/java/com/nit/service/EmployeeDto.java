package com.nit.service;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeDto {

	private Integer eId;
	private String eName;
	private String eSal;
	private Long ePhno;
	private List<AddressDto> adr;
}
