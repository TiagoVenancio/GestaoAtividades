package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.entities.TypeOfSubActivity;

public interface TypeOfSubActivityDao {

	List<TypeOfSubActivity> findAll();

	List<TypeOfSubActivity> findAllActivityAtivas();
	
	List<TypeOfSubActivity> listaSubActivityByActivity (TypeOfActivity typeOfActivity);

	void save(TypeOfSubActivity typeOfSubActivity);

	void update(TypeOfSubActivity typeOfSubActivity);

	TypeOfSubActivity getById(Long id);

}
