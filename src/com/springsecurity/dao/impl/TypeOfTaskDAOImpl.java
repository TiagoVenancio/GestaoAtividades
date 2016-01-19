package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springsecurity.dao.TypeOfTaskDAO;
import com.springsecurity.entities.TypeOfTask;

@Repository
@Transactional
public class TypeOfTaskDAOImpl implements TypeOfTaskDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfTask> findAll() {
		return entityManager.createQuery("FROM TypeOfTask").getResultList();
	}

	@Override
	public void save(TypeOfTask typeOfTask) {
		entityManager.persist(typeOfTask);

	}

	@Override
	public void update(TypeOfTask typeOfTask) {
		entityManager.persist(typeOfTask);

	}

	@Override
	public TypeOfTask getById(Long id) {
		return entityManager.find(TypeOfTask.class, id);
	}

}
