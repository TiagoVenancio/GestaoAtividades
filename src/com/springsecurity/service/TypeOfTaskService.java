package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.TypeOfTask;

public interface TypeOfTaskService {
	
	void adicionar(TypeOfTask typeOfTask) throws IllegalArgumentException;
	
	List<TypeOfTask> findAll();

}
