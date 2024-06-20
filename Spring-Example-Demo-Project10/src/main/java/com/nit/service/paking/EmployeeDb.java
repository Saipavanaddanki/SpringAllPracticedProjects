package com.nit.service.paking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDb extends JpaRepository<Employee,Integer> {

}
