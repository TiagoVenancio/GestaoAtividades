package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.RequestTask;
import com.springsecurity.entities.UserOwnerTask;

public interface RequestTaskService {

	List<RequestTask> buscarTaskPor(Long userOwnerTask);

	List<RequestTask> findForFiltros(String campo, String filtros);

	List<RequestTask> listaPorLogin(UserOwnerTask userOwnerTask);

	void adicionar(RequestTask requestTask) throws IllegalArgumentException;

	void salvar(RequestTask requestTask) throws IllegalArgumentException;

	void editar(RequestTask requestTask) throws IllegalArgumentException;

	public RequestTask getById(Long id);

	public List<RequestTask> getAllRequestTasks();

	public List<RequestTask> listarTarefasAFazer();

	public List<RequestTask> listarTarefasFazendo();

	public List<RequestTask> listarTarefasConcluido();

	public List<RequestTask> listarTarefasPendentes();
	
	public	List<RequestTask> listaLoginLogado(String id);
	
	public List<RequestTask> teste (Long login);
}
