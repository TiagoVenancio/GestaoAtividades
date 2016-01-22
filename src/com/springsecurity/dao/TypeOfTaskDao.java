package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfTask;

public interface TypeOfTaskDao {

	TypeOfTask getById(Long id);

	List<TypeOfTask> findAll();

	List<TypeOfTask> getAll();

	void save(TypeOfTask typeOfTask);

	void update(TypeOfTask typeOfTask);

}
