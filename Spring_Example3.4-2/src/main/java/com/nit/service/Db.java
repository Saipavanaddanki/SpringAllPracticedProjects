package com.nit.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Component
public interface Db extends JpaRepository<Login,Integer> {
	
	@Query(value="select * from login",nativeQuery=true)
	public List<Login> select();
	@Modifying
	@Query(value="update login set username=:name where userid=:id",nativeQuery=true)
	public int update(@Param("id") int id,@Param("name") String name);
	
	
	@Query(value="select s from Login s ")
	public List< Login> selectById();
}
