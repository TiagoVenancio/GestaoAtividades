package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springsecurity.dao.RequestTaskDAO;
import com.springsecurity.entities.RequestTask;

@Repository
@Transactional
public class RequestTaskDAOImpl implements RequestTaskDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> findAll() {
		return entityManager.createQuery("FROM RequestTask").getResultList();
	}

	@Override
	public void save(RequestTask requestTask) {
		entityManager.persist(requestTask);

	}

	@Override
	public void update(RequestTask requestTask) {
		entityManager.persist(requestTask);

	}

	@Override
	public RequestTask getById(Long id) {
		return entityManager.find(RequestTask.class, id);
	}

}
