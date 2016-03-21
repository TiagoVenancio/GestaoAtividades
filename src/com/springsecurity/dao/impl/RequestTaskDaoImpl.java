package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.RequestCustomerDao;
import com.springsecurity.entities.RequestCustomer;

@Repository
@Transactional
public class RequestTaskDaoImpl implements RequestCustomerDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public RequestCustomer getById(final Long id) {
		return entityManager.find(RequestCustomer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestCustomer> findAll() {
		return entityManager.createQuery(
				"FROM " + RequestCustomer.class.getName()).getResultList();
	}

	@Override
	public void save(RequestCustomer requestCustomer) {
		entityManager.persist(requestCustomer);

	}

	@Override
	public void update(RequestCustomer requestCustomer) {
		entityManager.merge(requestCustomer);

	}

}
