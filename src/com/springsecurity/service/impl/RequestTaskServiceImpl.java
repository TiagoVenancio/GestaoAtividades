package com.springsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.RequestTaskDao;
import com.springsecurity.entities.RequestTask;
import com.springsecurity.entities.UserOwnerTask;
import com.springsecurity.service.RequestTaskService;

@Service
@Transactional
public class RequestTaskServiceImpl implements RequestTaskService {

	@Autowired
	RequestTaskDao dao;

	@Override
	public void adicionar(RequestTask requestTask)
			throws IllegalArgumentException {
		dao.save(requestTask);

	}

	@Override
	public List<RequestTask> getAllRequestTasks() {
		return dao.findAll();
	}

	@Override
	public void editar(RequestTask requestTask) throws IllegalArgumentException {
		dao.update(requestTask);

	}

	@Override
	public RequestTask getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public List<RequestTask> listaPorLogin(UserOwnerTask userOwnerTask) {
		return dao.listaPorLogin(userOwnerTask);
	}

	@Override
	public void salvar(RequestTask requestTask) throws IllegalArgumentException {
		dao.save(requestTask);

	}

	@Override
	public List<RequestTask> listarTarefasAFazer() {
		return dao.findAllTarefasAfazer();

	}

	@Override
	public List<RequestTask> listarTarefasFazendo() {
		return dao.findAllTarefasFazendo();
	}

	@Override
	public List<RequestTask> listarTarefasConcluido() {
		return dao.findAllTarefasConcluido();

	}

	@Override
	public List<RequestTask> findForFiltros(String campo, String filtros) {
		return dao.findForFiltros(campo, filtros);
	}

	@Override
	public List<RequestTask> buscarTaskPor(Long userOwnerTask) {
		return dao.buscarTaskPor(userOwnerTask);
	}

	@Override
	public List<RequestTask> listarTarefasPendentes() {
		return dao.listarTarefasPendentes();
	}

}
