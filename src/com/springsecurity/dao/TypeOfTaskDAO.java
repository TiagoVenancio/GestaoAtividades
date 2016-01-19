package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfTask;

public interface TypeOfTaskDAO {
	
	List<TypeOfTask> findAll();

	void save(TypeOfTask typeOfTask);

	void update(TypeOfTask typeOfTask);

	TypeOfTask getById(Long id);


}
