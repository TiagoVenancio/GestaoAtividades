package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.springsecurity.dao.StatusOfTaskDao;
import com.springsecurity.entities.StatusOfTask;

@Repository
public class StatusOfTaskDaoImpl implements StatusOfTaskDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public StatusOfTask getById(final Long id) {
		return entityManager.find(StatusOfTask.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusOfTask> findAll() {
		return entityManager
				.createQuery("FROM " + StatusOfTask.class.getName())
				.getResultList();
	}

	@Override
	public void save(StatusOfTask statusOfTask) {
		entityManager.persist(statusOfTask);

	}

	@Override
	public void update(StatusOfTask statusOfTask) {
		entityManager.merge(statusOfTask);

	}

}
