package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfTask;

public interface TypeOfTaskDao {

	TypeOfTask getById(final Long id);

	List<TypeOfTask> findAll();

	void save(TypeOfTask typeOfTask);

	void update(TypeOfTask typeOfTask);

}
