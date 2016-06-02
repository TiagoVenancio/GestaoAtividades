package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.TypeOfActionDao;
import com.springsecurity.entities.TypeOfAction;
import com.springsecurity.enums.StatusObjectEnum;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfAction> findAtivos(){Query query = entityManager
			.createQuery("select t from TypeOfAction t where statusObjectEnum = :statusObjectEnum");
	query.setParameter("statusObjectEnum", StatusObjectEnum.Ativo);
	return query.getResultList();
	}

}
