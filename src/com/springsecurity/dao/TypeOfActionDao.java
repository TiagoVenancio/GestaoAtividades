package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfAction;

public interface TypeOfActionDao {
	
	public	TypeOfAction getById(Long id);
	
	public List<TypeOfAction> findAll();
	
	public List<TypeOfAction> findAtivos();

	void save(TypeOfAction typeOfAction);

	void update(TypeOfAction typeOfAction);

	
}
