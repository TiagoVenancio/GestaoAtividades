package com.springsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.UserOwnerTaskDAO;
import com.springsecurity.entities.UserOwnerTask;
import com.springsecurity.service.UserOwnerTaskService;

@Service
@Transactional
public class UserOwnerTaskServiceImpl implements UserOwnerTaskService {

	@Autowired
	private UserOwnerTaskDAO dao;

	@Override
	public void adicionar(UserOwnerTask userOwnerTask)
			throws IllegalArgumentException {
		dao.save(userOwnerTask);

	}

	@Override
	public void alterar(UserOwnerTask userOwnerTask)
			throws IllegalArgumentException {
		dao.update(userOwnerTask);

	}

	@Override
	public List<UserOwnerTask> getAll() {
		return dao.findAll();
	}

	@Override
	public UserOwnerTask getByIdUserOwnerTask(Long id) {
		return dao.getById(id);
	}

	@Override
	public List<UserOwnerTask> findAtivos() {
		return dao.findAtivos();
	}

}
