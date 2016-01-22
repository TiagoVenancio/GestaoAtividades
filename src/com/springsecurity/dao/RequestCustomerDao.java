package com.springsecurity.dao;

import java.util.List;
import com.springsecurity.entities.RequestCustomer;

public interface RequestCustomerDao {

	List<RequestCustomer> findAll();

	void save(RequestCustomer requestCustomer);

	void update(RequestCustomer requestCustomer);

	RequestCustomer getById(Long id);

}
