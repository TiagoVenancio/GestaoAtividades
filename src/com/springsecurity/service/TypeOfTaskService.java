package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.TypeOfTask;

public interface TypeOfTaskService {

	void adicionar(TypeOfTask typeOfTask) throws IllegalArgumentException;

	void alterar(TypeOfTask typeOfTask) throws IllegalArgumentException;

	public List<TypeOfTask> getAll();

	public TypeOfTask getByIdTypeOfTask(Long id);

}
