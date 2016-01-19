package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springsecurity.dao.TypeOfActivityDAO;
import com.springsecurity.entities.TypeOfActivity;

@Repository
@Transactional
public class TypeOfActivityDAOImpl implements TypeOfActivityDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfActivity> findAll() {
		return entityManager.createQuery("FROM TypeOfActivity").getResultList();
	}

	@Override
	public void save(TypeOfActivity typeOfActivity) {
		entityManager.persist(typeOfActivity);

	}

	@Override
	public void update(TypeOfActivity typeOfActivity) {
		entityManager.persist(typeOfActivity);

	}

	@Override
	public TypeOfActivity getById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(TypeOfActivity.class, id);
	}

}
