package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springsecurity.dao.TypeOfActionDAO;
import com.springsecurity.entities.TypeOfAction;

@Repository
@Transactional
public class TypeOfActionDAOImpl implements TypeOfActionDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfAction> findAll() {
		return entityManager.createQuery("FROM TypeOfAction").getResultList();
	}

	@Override
	public void save(TypeOfAction typeOfAction) {
		entityManager.persist(typeOfAction);
	}

	@Override
	public void update(TypeOfAction typeOfAction) {
		entityManager.persist(typeOfAction);
	}

	@Override
	public TypeOfAction getById(Long id) {
		return entityManager.find(TypeOfAction.class, id);
	}

}
