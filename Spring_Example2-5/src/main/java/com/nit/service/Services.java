package com.nit.service;

import java.util.List;

public interface Services {

	void insert(String name,int id,double sal);
	void delete(int id);
	void deleteAll(List<Integer> list);
}
