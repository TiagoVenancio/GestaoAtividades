package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.TypeOfGroupDao;
import com.springsecurity.entities.TypeOfGroup;

@Repository
@Transactional
public class TypeOfGroupDaoImpl implements TypeOfGroupDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TypeOfGroup getById(final Long id) {
		return entityManager.find(TypeOfGroup.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfGroup> findAll() {
		return entityManager.createQuery("FROM " + TypeOfGroup.class.getName())
				.getResultList();
	}

	@Override
	public void save(TypeOfGroup typeOfGroup) {
		entityManager.persist(typeOfGroup);

	}

	@Override
	public void update(TypeOfGroup typeOfGroup) {
		entityManager.merge(typeOfGroup);

	}

}
