package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Register_user")
public class Register {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userNo;
	private String userName;
	private String userEmail;
	
}
