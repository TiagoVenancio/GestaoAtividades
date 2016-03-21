package com.springsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.UserDAO;
import com.springsecurity.entities.User;
import com.springsecurity.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public List<User> getAll() {
		return dao.findAll();
	}

	@Override
	public User getByIdUser(Long id) {
		return dao.getById(id);
	}

}
