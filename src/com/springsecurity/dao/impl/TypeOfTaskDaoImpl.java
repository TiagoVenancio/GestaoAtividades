package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springsecurity.dao.TypeOfTaskDao;
import com.springsecurity.entities.TypeOfTask;

@Repository
public class TypeOfTaskDaoImpl implements TypeOfTaskDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public TypeOfTask buscaPorId(Long id) {
		return manager.find(TypeOfTask.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOfTask> lista() {
		return manager.createQuery("select t from TypeOfTask t")
				.getResultList();
	}

	@Override
	public void adiciona(TypeOfTask t) {
		manager.persist(t);

	}

	@Override
	public void altera(TypeOfTask t) {
		manager.merge(t);

	}

}
