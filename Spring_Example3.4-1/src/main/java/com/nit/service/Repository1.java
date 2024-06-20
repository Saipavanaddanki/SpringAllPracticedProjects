package com.nit.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;


@Transactional
public interface Repository1 extends JpaRepository<UserLogin,Integer> {

	@Modifying
	@Query(value="insert into user_login values(:id,:name,:sal)",nativeQuery = true)
	public void insert(@Param("id") int id,@Param("sal")  Double sal,@Param("name") String name);
	
	@Query(value="select * from user_login",nativeQuery = true)
	public List<UserLogin> select();
}
