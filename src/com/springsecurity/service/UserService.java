package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.User;

public interface UserService {

	public List<User> getAll();

	public User getByIdUser(Long id);

}
