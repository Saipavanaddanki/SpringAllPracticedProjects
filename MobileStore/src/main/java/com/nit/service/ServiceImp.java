package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceImp {

	@Autowired
	MobileDb mobile;
	
	public String booking(MobileStoreDto m1) {
		MobileStore m2=new MobileStore();
		m2.setMobileId(m1.getMobileId());
		m2.setMobileName(m1.getMobileName());
		m2.setPrice(m1.getPrice());
		mobile.save(m2);
		return "Booked SuccessFully";
	}
	
	public MobileStore bookingDetails(int id) {
		java.util.Optional<MobileStore>  details=(mobile.findById(id));
		return details.orElseThrow(()->new RuntimeException("invalid Id"));
	}
	
}
