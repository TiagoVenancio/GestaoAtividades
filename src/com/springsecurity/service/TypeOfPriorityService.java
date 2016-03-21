package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.TypeOfPriority;

public interface TypeOfPriorityService {

	void adicionar(TypeOfPriority typeOfPriority)
			throws IllegalArgumentException;

	void alterar(TypeOfPriority typeOfPriority) throws IllegalArgumentException;

	public List<TypeOfPriority> getAllTipoDePrioridades();

	List<TypeOfPriority> findAll();

	public TypeOfPriority getByIdTypeOfPriority(Long id);

}
