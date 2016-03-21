package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.TypeOfGroup;

public interface TypeOfGroupService {

	void adicionar(TypeOfGroup typeOfGroup) throws IllegalArgumentException;

	void alterar(TypeOfGroup typeOfGroup) throws IllegalArgumentException;

	public List<TypeOfGroup> getAll();

	public TypeOfGroup getByIdTypeOfGroup(Long id);

}
