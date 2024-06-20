package com.nit.service.Dto;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class CustomerRegDto {
	private  String customer_Name;
	private  String customer_Email;
	private Long customer_Phno;
	private Customer_Address  address;
}
