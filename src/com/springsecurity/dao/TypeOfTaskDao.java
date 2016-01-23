package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfTask;

public interface TypeOfTaskDao {

	public TypeOfTask getById(Long id);

	public List<TypeOfTask> getAllTipoDeTarefas();

	void save(TypeOfTask typeOfTask);

	void update(TypeOfTask typeOfTask);

}
