package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfPriority;

public interface TypeOfPriorityDao {

	List<TypeOfPriority> findAll();

	void save(TypeOfPriority typeOfPriority);

	void update(TypeOfPriority typeOfPriority);

	TypeOfPriority getById(Long id);

}