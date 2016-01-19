package com.springsecurity.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.TypeOfPriorityDAO;
import com.springsecurity.entities.TypeOfPriority;


@Repository
@Transactional
public class TypeOfPriorityDAOImpl implements TypeOfPriorityDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfPriority> findAll() {
		return entityManager.createQuery("FROM TypeOfPriority").getResultList();
	}

	@Override
	public void save(TypeOfPriority typeOfPriority) {
		entityManager.persist(typeOfPriority);
		
	}

	@Override
	public void update(TypeOfPriority typeOfPriority) {
		entityManager.persist(typeOfPriority);
		
	}

	@Override
	public TypeOfPriority getById(Long id) {
		return entityManager.find(TypeOfPriority.class, id);
	}
	

}
