package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.UserOwnerTask;

public interface UserOwnerTaskService {

	void adicionar(UserOwnerTask userOwnerTask) throws IllegalArgumentException;

	void alterar(UserOwnerTask userOwnerTask) throws IllegalArgumentException;

	public List<UserOwnerTask> getAll();
	
	public List<UserOwnerTask> findAtivos();

	public UserOwnerTask getByIdUserOwnerTask(Long id);

}
