package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.RequestTask;

public interface RequestTaskService {

	List<RequestTask> buscarTaskPor(RequestTask requestTask);

	void adicionar(RequestTask requestTask) throws IllegalArgumentException;

	void editar(RequestTask requestTask) throws IllegalArgumentException;

	public List<RequestTask> getAllRequestTasks();

}
