package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springsecurity.dao.StatusOfTaskDAO;
import com.springsecurity.entities.StatusOfTask;

@Repository
@Transactional
public class StatusOfTaskDAOImpl implements StatusOfTaskDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusOfTask> findAll() {
		return entityManager.createQuery("FROM StatusOfTask").getResultList();
	}

	@Override
	public void save(StatusOfTask statusOfTask) {
		entityManager.persist(statusOfTask);

	}

	@Override
	public void update(StatusOfTask statusOfTask) {
		entityManager.persist(statusOfTask);

	}

	@Override
	public StatusOfTask getById(Long id) {
		return entityManager.find(StatusOfTask.class, id);
	}

}
