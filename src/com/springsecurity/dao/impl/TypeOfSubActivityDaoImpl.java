package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.TypeOfSubActivityDao;
import com.springsecurity.entities.TypeOfSubActivity;
import com.springsecurity.enums.StatusObjectEnum;

@Repository
@Transactional
public class TypeOfSubActivityDaoImpl implements TypeOfSubActivityDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TypeOfSubActivity getById(final Long id) {
		return entityManager.find(TypeOfSubActivity.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfSubActivity> findAll() {
		return entityManager.createQuery(
				"FROM " + TypeOfSubActivity.class.getName()).getResultList();
	}

	@Override
	public void save(TypeOfSubActivity typeOfSubActivity) {
		entityManager.persist(typeOfSubActivity);

	}

	@Override
	public void update(TypeOfSubActivity typeOfSubActivity) {
		entityManager.merge(typeOfSubActivity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfSubActivity> findAllActivityAtivas() {
		Query query = entityManager
				.createQuery("select t from TypeOfSubActivity t where statusObjectEnum = :statusObjectEnum");
		query.setParameter("statusObjectEnum", StatusObjectEnum.Ativo);
		return query.getResultList();
	}

}
