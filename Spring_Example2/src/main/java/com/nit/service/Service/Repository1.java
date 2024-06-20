package com.nit.service.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.service.Dto.CustomerRegDto;

@Repository
public interface Repository1  extends JpaRepository<Customer_Reg,String> {

}
