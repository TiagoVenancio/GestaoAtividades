package com.springsecurity.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springsecurity.dao.RequestTaskDao;
import com.springsecurity.entities.RequestTask;

@Repository
@Transactional
public class RequestCustomerDaoImpl implements RequestTaskDao {

	@PersistenceContext
	private EntityManager entityManager;
	private Session session;

	@Override
	public RequestTask getById(final Long id) {
		return entityManager.find(RequestTask.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> findAll() {
		return entityManager.createQuery("FROM " + RequestTask.class.getName())
				.getResultList();
	}

	@Override
	public void save(RequestTask requestTask) {
		entityManager.persist(requestTask);

	}

	@Override
	public void update(RequestTask requestTask) {
		entityManager.merge(requestTask);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> buscarTaskPor(RequestTask requestTask) {
		Criteria cr = session.createCriteria(RequestTask.class);
		cr.add(Restrictions.like("resume", "%resume%"));
		cr.add(Restrictions.eq("typeOfActivity", requestTask.getTypeOfActivity()));
		cr.add(Restrictions.eq("typeOfSubActivity",	requestTask.getTypeOfActivity())); // ALTERAR AQUI PARA SUB-ATIVIDADE
		cr.add(Restrictions.between("conclusionDate",requestTask.getConclusionDate(),requestTask.getConclusionDate()));

		List<RequestTask> results = cr.list();

		return results;
	}

}
