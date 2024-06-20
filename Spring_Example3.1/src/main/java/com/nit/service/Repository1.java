package com.nit.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repository1 extends JpaRepository<Users,Integer> {

}
