package com.springsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.RequestTaskDao;
import com.springsecurity.entities.RequestTask;
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

}
