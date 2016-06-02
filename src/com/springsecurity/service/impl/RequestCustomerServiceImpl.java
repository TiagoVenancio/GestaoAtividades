package com.springsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.RequestCustomerDao;
import com.springsecurity.entities.RequestCustomer;
import com.springsecurity.service.RequestCustomerService;

@Service
@Transactional
public class RequestCustomerServiceImpl implements RequestCustomerService {

	@Autowired
	private RequestCustomerDao dao;

	@Override
	public void adicionar(RequestCustomer requestCustomer)
			throws IllegalArgumentException {
		dao.save(requestCustomer);

	}

	@Override
	public List<RequestCustomer> getAllRequestCustomers() {
		return dao.findAll();
	}
	

	@Override
	public void alterar(RequestCustomer requestCustomer)
			throws IllegalArgumentException {
		dao.update(requestCustomer);

	}

	@Override
	public RequestCustomer getByIdRequestCustomer(Long id) {
		return dao.getById(id);
	}

	@Override
	public List<RequestCustomer> findAtivos() {
		return dao.findAtivos();
	}

}
