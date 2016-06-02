package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.RequestTask;
import com.springsecurity.entities.UserOwnerTask;

public interface RequestTaskDao {

	public	List<RequestTask> findAll();

	public	List<RequestTask> buscarTaskPor(Long userOwnerTask);

	public	List<RequestTask> listaPorLogin(UserOwnerTask userOwnerTask);

	public	List<RequestTask> findAllTarefasAfazer();

	public	List<RequestTask> findAllTarefasFazendo();

	public	List<RequestTask> findAllTarefasConcluido();
	
	public	List<RequestTask> listaLoginLogado(String id);

	void save(RequestTask requestTask);

	void update(RequestTask requestTask);

	RequestTask getById(Long id);

	public List<RequestTask> findForFiltros(String campo, String filtros);

	public List<RequestTask> listarTarefasPendentes();

	public List<RequestTask> teste (Long login);
	
}
