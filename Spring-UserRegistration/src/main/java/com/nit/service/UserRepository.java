package com.nit.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository  extends JpaRepository<UserRegistration,Integer>{

	@Modifying
	@Query(value="insert into user_registration values(id,name,sal,adrlist)",nativeQuery = true)
	public void insert(@Param("Id") int id,@Param("name")String name,@Param("sal") double sal, @Param("adlist") List<Address> adrlist);
}
