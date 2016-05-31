package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.RequestTask;
import com.springsecurity.entities.UserOwnerTask;

public interface RequestTaskDao {

	List<RequestTask> findAll();	

	List<RequestTask> buscarTaskPor(RequestTask requestTask);
	
	List<RequestTask> listaPorLogin(UserOwnerTask userOwnerTask);
	
	List<RequestTask> findAllTarefasAfazer();
	
	List<RequestTask> findAllTarefasFazendo();
	
	List<RequestTask> findAllTarefasConcluido();

	void save(RequestTask requestTask);

	void update(RequestTask requestTask);

	RequestTask getById(Long id);

}
