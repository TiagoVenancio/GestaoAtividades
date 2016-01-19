package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfActivity;

public interface TypeOfActivityDAO {

	List<TypeOfActivity> findAll();

	void save(TypeOfActivity typeOfActivity);

	void update(TypeOfActivity typeOfActivity);

	void remove(TypeOfActivity typeOfActivity);

	TypeOfActivity getById(Long id);

}
