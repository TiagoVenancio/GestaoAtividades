package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.UserOwnerTask;

public interface UserOwnerTaskDAO {

	public	List<UserOwnerTask> findAll();
	
	public List<UserOwnerTask> findAtivos();

	void save(UserOwnerTask userOwnerTask);

	void update(UserOwnerTask userOwnerTask);

	void remove(UserOwnerTask userOwnerTask);

	UserOwnerTask getById(Long id);

}
