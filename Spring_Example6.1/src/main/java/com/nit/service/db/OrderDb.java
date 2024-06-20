package com.nit.service.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.service.Orders;
@Repository
public interface OrderDb extends JpaRepository<Orders,String> {

}
