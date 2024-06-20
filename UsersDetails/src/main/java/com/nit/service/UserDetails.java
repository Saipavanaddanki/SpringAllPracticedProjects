package com.nit.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="User_Details")
public class UserDetails {
	@Id
	private int userId;
	private String userName;
	private String password;
	private long mobile;
	private String email;
}
