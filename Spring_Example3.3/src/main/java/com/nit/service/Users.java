package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="userss1")
public class Users {
	@Id
	private int userId;
	private String userName;
	private double userSal;
	private String gender;
	

}
