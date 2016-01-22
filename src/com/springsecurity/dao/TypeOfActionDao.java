package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfAction;

public interface TypeOfActionDao {

	List<TypeOfAction> findAll();

	void save(TypeOfAction typeOfAction);

	void update(TypeOfAction typeOfAction);

	TypeOfAction getById(Long id);

}
