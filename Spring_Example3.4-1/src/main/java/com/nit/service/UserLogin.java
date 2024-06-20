package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="user_login")
public class UserLogin {

	@Id
	private int userId;
	private String userName;
	private Double sal;
	

}
