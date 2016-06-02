package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.UserOwnerTaskDAO;
import com.springsecurity.entities.UserOwnerTask;
import com.springsecurity.enums.StatusObjectEnum;

@Repository
@Transactional
public class UserOwnerTaskDAOImpl implements UserOwnerTaskDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserOwnerTask> findAll() {
		return entityManager.createQuery(
				"FROM " + UserOwnerTask.class.getName()).getResultList();
	}

	@Override
	public void save(UserOwnerTask userOwnerTask) {
		entityManager.persist(userOwnerTask);

	}

	@Override
	public void update(UserOwnerTask userOwnerTask) {
		entityManager.merge(userOwnerTask);

	}

	@Override
	public void remove(UserOwnerTask userOwnerTask) {

	}

	@Override
	public UserOwnerTask getById(Long id) {
		return entityManager.find(UserOwnerTask.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserOwnerTask> findAtivos() {Query query = entityManager
			.createQuery("select t from UserOwnerTask t where statusObjectEnum = :statusObjectEnum");
	query.setParameter("statusObjectEnum", StatusObjectEnum.Ativo);
	return query.getResultList();
	}

}
