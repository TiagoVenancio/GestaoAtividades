package com.springsecurity.service;

import java.util.List;
import com.springsecurity.entities.RequestCustomer;

public interface RequestCustomerService {

	void adicionar(RequestCustomer requestCustomer) throws IllegalArgumentException;

	List<RequestCustomer> findAll();

}
