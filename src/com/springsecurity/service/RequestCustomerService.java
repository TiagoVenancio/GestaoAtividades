package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.RequestCustomer;

public interface RequestCustomerService {

	void adicionar(RequestCustomer requestCustomer)
			throws IllegalArgumentException;

	void alterar(RequestCustomer requestCustomer)
			throws IllegalArgumentException;

	public List<RequestCustomer> getAllRequestCustomers();
	
	public List<RequestCustomer> findAtivos();

	public RequestCustomer getByIdRequestCustomer(Long id);

}
