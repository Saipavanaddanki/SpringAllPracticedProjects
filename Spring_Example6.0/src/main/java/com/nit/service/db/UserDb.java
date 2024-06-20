package com.nit.service.db;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.service.UserRegistration;
@Repository
public interface UserDb  extends JpaRepository<UserRegistration,String>{
	List<UserRegistration> findAllByName(String name);

}
