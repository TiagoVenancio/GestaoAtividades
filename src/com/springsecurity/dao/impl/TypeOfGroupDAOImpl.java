package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springsecurity.dao.TypeOfGroupDAO;
import com.springsecurity.entities.TypeOfGroup;

@Repository
@Transactional
public class TypeOfGroupDAOImpl implements TypeOfGroupDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfGroup> findAll() {
		return entityManager.createQuery("FROM TypeOfGroup").getResultList();
	}

	@Override
	public void save(TypeOfGroup typeOfGroup) {
		entityManager.persist(typeOfGroup);

	}

	@Override
	public void update(TypeOfGroup typeOfGroup) {
		entityManager.persist(typeOfGroup);

	}

	@Override
	public TypeOfGroup getById(Long id) {
		return entityManager.find(TypeOfGroup.class, id);
	}

}
