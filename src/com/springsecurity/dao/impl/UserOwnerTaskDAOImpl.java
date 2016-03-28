package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.UserOwnerTaskDAO;
import com.springsecurity.entities.UserOwnerTask;

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

}
