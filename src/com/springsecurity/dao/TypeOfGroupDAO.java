package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfGroup;

public interface TypeOfGroupDAO {

	List<TypeOfGroup> findAll();

	void save(TypeOfGroup typeOfGroup);

	void update(TypeOfGroup typeOfGroup);

	TypeOfGroup getById(Long id);

}