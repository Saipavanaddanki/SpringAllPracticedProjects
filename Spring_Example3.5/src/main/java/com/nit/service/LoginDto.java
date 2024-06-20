package com.nit.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="login")
@Data
public class LoginDto {
	@Id
	@Column(name="userId")
	private int userId;
	@Column(name="userName")
	private String userName;
	@Column(name="userSal")
	private double userSal;
}
