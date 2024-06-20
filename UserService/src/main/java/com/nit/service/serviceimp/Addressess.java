package com.nit.service.serviceimp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="Address_Details")
public class Addressess {

	@Id
	private int pincode;
	private String street;
	private String city;
}
