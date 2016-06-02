package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfPriority;

public interface TypeOfPriorityDao {

	public List<TypeOfPriority> findAll();
	
	public List<TypeOfPriority> findAtivos();

	void save(TypeOfPriority typeOfPriority);

	void update(TypeOfPriority typeOfPriority);

	TypeOfPriority getById(Long id);

}
