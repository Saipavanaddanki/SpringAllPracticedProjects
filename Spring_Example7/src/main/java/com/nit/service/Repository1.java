package com.nit.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Repository1 extends JpaRepository<UserRegistration,String> {

	@Query(value="select * from user_registration u where u.email in (select user_address from address_details) order by email",nativeQuery = true)
	List<UserRegistration> retrive();

}
