package com.nit.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserRegistration,Integer>{

	UserRegistration findByName(String username);

}
