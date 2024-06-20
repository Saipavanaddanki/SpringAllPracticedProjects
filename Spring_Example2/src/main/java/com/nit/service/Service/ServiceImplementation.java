package com.nit.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.service.Dto.CustomerRegDto;

@Service
public class ServiceImplementation implements Services {

	@Autowired
	Repository1 repo;
	@Override
	public String insert(CustomerRegDto dto) {
		Customer_Reg reg=new Customer_Reg();
		System.out.println(dto.toString());
		reg.setCustomer_Name(dto.getCustomer_Name());
		reg.setCustomer_Email(dto.getCustomer_Email());
		reg.setCustomer_Phno(dto.getCustomer_Phno());
		Customer_Address adr=new Customer_Address();
		adr.setStreet(dto.getAddress().getStreet());
		adr.setCity(dto.getAddress().getCity());
		adr.setDrno(dto.getAddress().getDrno());
		reg.setCustomer_Address(adr);
	   Customer_Reg credg=	repo.save(reg);
	   
		
		return "Registered Successfully  "+credg.getCustomer_Email()+"   Now You Can Login into Your Account";
	}

}
