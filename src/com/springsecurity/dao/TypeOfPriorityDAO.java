package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfPriority;

public interface TypeOfPriorityDAO {

	List<TypeOfPriority> findAll();

	void save(TypeOfPriority typeOfPriority);

	void update(TypeOfPriority typeOfPriority);

	void remove(TypeOfPriority typeOfPriority);

	TypeOfPriority getById(Long id);

}
