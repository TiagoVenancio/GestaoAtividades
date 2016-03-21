package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.RequestTaskDao;
import com.springsecurity.entities.RequestTask;

@Repository
@Transactional
public class RequestCustomerDaoImpl implements RequestTaskDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public RequestTask getById(final Long id) {
		return entityManager.find(RequestTask.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> findAll() {
		return entityManager.createQuery(
				"FROM " + RequestTask.class.getName()).getResultList();
	}

	@Override
	public void save(RequestTask requestTask) {
		entityManager.persist(requestTask);

	}

	@Override
	public void update(RequestTask requestTask) {
		entityManager.merge(requestTask);

	}

}
