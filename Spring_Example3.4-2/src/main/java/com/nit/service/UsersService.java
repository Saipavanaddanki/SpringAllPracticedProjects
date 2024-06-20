package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

@Component
public class UsersService {

	@Autowired
	Db db;
 
	
	 public void select() {
		 db.select().forEach(System.out::println);
	 }
	 public void update(int id,String name) {
		 db.update(id,name);
	 }
	 
	 public void selectById(int id) {
		db.selectById().forEach(System.out::println);
	 }
	 
	// Pageable
	 public void selectByFindMethod() {
		 db.findAll(Sort.by(Direction.DESC, "userSal","UserId")).forEach(System.out::println);
	 }
	 Pageable page=PageRequest.of(2, 1, Direction.DESC, "UserId");
	 public void selectByFindByMethod2() {
		 db.findAll(page).forEach(System.out::println);
	 }
	 
}
