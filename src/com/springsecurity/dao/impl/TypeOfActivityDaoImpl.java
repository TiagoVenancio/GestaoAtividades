package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.TypeOfActivityDao;
import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.enums.StatusObjectEnum;

@Repository
@Transactional
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
		return entityManager.createQuery(
				"FROM " + TypeOfActivity.class.getName()).getResultList();
	}

	@Override
	public void save(TypeOfActivity typeOfActivity) {
		entityManager.persist(typeOfActivity);

	}

	@Override
	public void update(TypeOfActivity typeOfActivity) {
		entityManager.merge(typeOfActivity);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfActivity> findAtivos() {Query query = entityManager
			.createQuery("select t from TypeOfActivity t where statusObjectEnum = :statusObjectEnum");
	query.setParameter("statusObjectEnum", StatusObjectEnum.Ativo);
	return query.getResultList();
	}

}
