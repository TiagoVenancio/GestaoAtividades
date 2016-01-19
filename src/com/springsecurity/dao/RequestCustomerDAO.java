package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.RequestCustomer;

public interface RequestCustomerDAO {
	
	List<RequestCustomer> findAll();

	void save(RequestCustomer requestCustomer);

	void update(RequestCustomer requestCustomer);

	RequestCustomer getById(Long id);


}
