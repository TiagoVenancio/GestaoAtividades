package com.springsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.StatusOfTaskDao;
import com.springsecurity.entities.StatusOfTask;
import com.springsecurity.service.StatusOfTaskService;

@Service
@Transactional
public class StatusOfTaskServiceImpl implements StatusOfTaskService {

	@Autowired
	StatusOfTaskDao dao;

	@Override
	public void adicionar(StatusOfTask statusOfTask)
			throws IllegalArgumentException {
		dao.save(statusOfTask);

	}

	@Override
	public List<StatusOfTask> findAll() {
		return findAll();
	}

}
