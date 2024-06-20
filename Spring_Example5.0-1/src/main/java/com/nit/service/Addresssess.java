package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;


@Data
@Entity
@Table(name="Address_Details")
public class Addresssess {
	private String city;
	private String street;
	@Id
	private int pincode;
   
}
//class Addr{
//	private String city;
//	private String street;
//	private int pincode;
//    
//	public Addr builder() {
//		return new Addr();
//	}
//	public Addr setCity(String city) {
//		this.city = city;
//		return this;
//	}
//
//	public Addr setStreet(String street) {
//		this.street = street;
//		return this;
//	}
//
//	public Addr setPincode(int pincode) {
//		this.pincode = pincode;
//		return this;
//	}
//	
//	public Addresssess build() {
//		return new Addresssess(city,street,pincode);
//	}
//    
//    
//	
//}