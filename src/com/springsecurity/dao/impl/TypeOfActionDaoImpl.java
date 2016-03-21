package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.TypeOfActionDao;
import com.springsecurity.entities.TypeOfAction;

@Repository
@Transactional
public class TypeOfActionDaoImpl implements TypeOfActionDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TypeOfAction getById(final Long id) {
		return entityManager.find(TypeOfAction.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfAction> findAll() {
		return entityManager
				.createQuery("FROM " + TypeOfAction.class.getName())
				.getResultList();
	}

	@Override
	public void save(TypeOfAction typeOfAction) {
		entityManager.persist(typeOfAction);

	}

	@Override
	public void update(TypeOfAction typeOfAction) {
		entityManager.merge(typeOfAction);

	}

}
