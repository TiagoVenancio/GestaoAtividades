package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springsecurity.dao.TypeOfActivityDao;
import com.springsecurity.entities.TypeOfActivity;

@Repository
public class TypeOfActivityDaoImpl implements TypeOfActivityDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TypeOfActivity getById(final Long id) {
		return entityManager.find(TypeOfActivity.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfActivity> findAll() {
		return entityManager.createQuery("FROM " + TypeOfActivity.class.getName())
				.getResultList();
	}

	@Override
	public void save(TypeOfActivity typeOfActivity) {
		entityManager.persist(typeOfActivity);

	}

	@Override
	public void update(TypeOfActivity typeOfActivity) {
		entityManager.merge(typeOfActivity);

	}

}
