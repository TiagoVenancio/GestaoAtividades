package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.TypeOfActivity;

public interface TypeOfActivityService {

	void adicionar(TypeOfActivity typeOfActivity)
			throws IllegalArgumentException;

	void alterar(TypeOfActivity typeOfActivity) throws IllegalArgumentException;

	public List<TypeOfActivity> getAllTipoDeAtividades();

	public TypeOfActivity getByIdTypeOfActivity(Long id);

}
