package com.nit.service;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="user_registration")
class UserRegistration{

	@Id
	private String email;
	private String name;
	private String password;
	private long mobile;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_address")
	private List<Addressess> address;
}
