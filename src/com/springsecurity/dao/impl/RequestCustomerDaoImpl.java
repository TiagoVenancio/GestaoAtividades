package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.RequestCustomerDao;
import com.springsecurity.entities.RequestCustomer;
import com.springsecurity.enums.StatusObjectEnum;

@Repository
@Transactional
public class RequestCustomerDaoImpl implements RequestCustomerDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public RequestCustomer getById(Long id) {
		return entityManager.find(RequestCustomer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestCustomer> findAll() {
		return entityManager.createQuery(
				"FROM " + RequestCustomer.class.getName()).getResultList();
	}

	@Override
	public void save(RequestCustomer requestCustomer) {
		entityManager.persist(requestCustomer);

	}

	@Override
	public void update(RequestCustomer requestCustomer) {
		entityManager.merge(requestCustomer);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RequestCustomer> findAtivos() {Query query = entityManager
			.createQuery("select t from RequestCustomer t where statusObjectEnum = :statusObjectEnum");
	query.setParameter("statusObjectEnum", StatusObjectEnum.Ativo);
	return query.getResultList();
		
	}
	

}
