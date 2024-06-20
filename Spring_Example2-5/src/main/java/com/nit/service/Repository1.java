package com.nit.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
@Component
public interface Repository1 extends JpaRepository<Employee,Integer> {

}
