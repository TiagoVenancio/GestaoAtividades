package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfSubActivity;

public interface TypeOfSubActivityDao {

	List<TypeOfSubActivity> findAll();

	List<TypeOfSubActivity> findAllActivityAtivas();

	void save(TypeOfSubActivity typeOfSubActivity);

	void update(TypeOfSubActivity typeOfSubActivity);

	TypeOfSubActivity getById(Long id);

}
