package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springsecurity.dao.TypeOfTaskDao;
import com.springsecurity.entities.TypeOfTask;

@Repository
public class TypeOfTaskDaoImpl implements TypeOfTaskDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TypeOfTask getById(final Long id) {
		return entityManager.find(TypeOfTask.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfTask> findAll() {
		return entityManager.createQuery("FROM " + TypeOfTask.class.getName())
				.getResultList();
	}

	@Override
	public void save(TypeOfTask typeOfTask) {
		entityManager.persist(typeOfTask);

	}

	@Override
	public void update(TypeOfTask typeOfTask) {
		entityManager.merge(typeOfTask);

	}

}
