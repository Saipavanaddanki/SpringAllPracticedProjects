package com.nit.service;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Products {
  private int pid;
  private String pname;
}
