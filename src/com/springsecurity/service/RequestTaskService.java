package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.RequestTask;

public interface RequestTaskService {

	void adicionar(RequestTask requestTask) throws IllegalArgumentException;

	public List<RequestTask> getAllRequestTasks();

}
