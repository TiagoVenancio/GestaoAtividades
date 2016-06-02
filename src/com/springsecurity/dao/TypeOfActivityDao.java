package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfActivity;

public interface TypeOfActivityDao {

	public List<TypeOfActivity> findAll();

	public List<TypeOfActivity> findAtivos();

	void save(TypeOfActivity typeOfActivity);

	void update(TypeOfActivity typeOfActivity);

	TypeOfActivity getById(Long id);

}
