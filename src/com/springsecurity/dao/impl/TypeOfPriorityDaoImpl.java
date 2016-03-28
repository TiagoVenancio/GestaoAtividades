package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.TypeOfPriorityDao;
import com.springsecurity.entities.TypeOfPriority;
import com.springsecurity.enums.StatusObjectEnum;

@Repository
@Transactional
public class TypeOfPriorityDaoImpl implements TypeOfPriorityDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TypeOfPriority getById(final Long id) {
		return entityManager.find(TypeOfPriority.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfPriority> findAll() {
		return entityManager.createQuery(
				"FROM " + TypeOfPriority.class.getName()).getResultList();
	}

	@Override
	public void save(TypeOfPriority typeOfPriority) {
		entityManager.persist(typeOfPriority);

	}

	@Override
	public void update(TypeOfPriority typeOfPriority) {
		entityManager.merge(typeOfPriority);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfPriority> findAllPrioridadesAtivas() {
		Query query = entityManager
				.createQuery("select t from TypeOfPriority t where statusObjectEnum = :statusObjectEnum");
		query.setParameter("statusObjectEnum", StatusObjectEnum.Ativo);
		return query.getResultList();
	}

}
