package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.RequestCustomerDAO;
import com.springsecurity.entities.RequestCustomer;

@Repository
@Transactional
public class RequestCustomerDAOImpl implements RequestCustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestCustomer> findAll() {
		return entityManager.createQuery("FROM RequestCustomer")
				.getResultList();
	}

	@Override
	public void save(RequestCustomer requestCustomer) {
		entityManager.persist(requestCustomer);

	}

	@Override
	public void update(RequestCustomer requestCustomer) {
		entityManager.persist(requestCustomer);

	}

	@Override
	public RequestCustomer getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
