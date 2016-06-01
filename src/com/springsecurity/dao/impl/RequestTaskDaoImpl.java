package com.springsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.RequestTaskDao;
import com.springsecurity.entities.RequestTask;
import com.springsecurity.entities.UserOwnerTask;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.enums.StatusTaskEnum;

@Repository
@Transactional
public class RequestTaskDaoImpl implements RequestTaskDao {

	@PersistenceContext
	private EntityManager entityManager;
	private Session session;

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> findAll() {
		return entityManager.createQuery("FROM " + RequestTask.class.getName())
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> buscarTaskPor(Long userOwnerTask) {
		Criteria cr = session.createCriteria(RequestTask.class);
		cr.add(Restrictions.eq("userOwnerTask", userOwnerTask));
		/*
		 * cr.add(Restrictions.eq("typeOfActivity",requestTask.getTypeOfActivity(
		 * ))); cr.add(Restrictions.eq("typeOfSubActivity",
		 * requestTask.getTypeOfSubActivity()));
		 * cr.add(Restrictions.like("resume", "%resume%"));
		 * cr.add(Restrictions.between
		 * ("conclusionDate",requestTask.getConclusionDate
		 * (),requestTask.getConclusionDate()));
		 * cr.add(Restrictions.between("startDate",
		 * requestTask.getStartDate(),requestTask.getConclusionDate()));
		 */

		List<RequestTask> results = cr.list();

		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> listaPorLogin(UserOwnerTask userOwnerTask) {
		Query query = entityManager
				.createQuery("select t from RequestTask t where userOwnerTask = :userOwnerTask");
		query.setParameter("userOwnerTask", userOwnerTask);
		return query.getResultList();
	}

	@Override
	public void save(RequestTask requestTask) {
		entityManager.persist(requestTask);

	}

	@Override
	public void update(RequestTask requestTask) {
		entityManager.merge(requestTask);

	}

	@Override
	public RequestTask getById(Long id) {
		return entityManager.find(RequestTask.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> findAllTarefasAfazer() {
		Query query = entityManager
				.createQuery("select t from RequestTask t where statusTaskEnum = :statusTaskEnum");
		query.setParameter("statusTaskEnum", StatusTaskEnum.A_FAZER);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> findAllTarefasFazendo() {
		Query query = entityManager
				.createQuery("select t from RequestTask t where statusTaskEnum = :statusTaskEnum");
		query.setParameter("statusTaskEnum", StatusTaskEnum.FAZENDO);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> findAllTarefasConcluido() {
		Query query = entityManager
				.createQuery("select t from RequestTask t where statusTaskEnum = :statusTaskEnum");
		query.setParameter("statusTaskEnum", StatusTaskEnum.CONCLUIDA);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> findForFiltros(String campo, String filtros) {
		return entityManager.createQuery(
				"FROM " + RequestTask.class.getName() + " where " + campo
						+ "like '%" + filtros + "%'").getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestTask> listarTarefasPendentes() {
		Query query = entityManager
				.createQuery("select t from RequestTask t where statusObjectEnum = :statusObjectEnum");
		query.setParameter("statusObjectEnum", StatusObjectEnum.Ativo);
		return query.getResultList();
	}

}
