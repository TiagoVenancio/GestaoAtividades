package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.TypeOfAction;

public interface TypeOfActionService {

	void adicionar(TypeOfAction typeOfAction) throws IllegalArgumentException;

	void alterar(TypeOfAction typeOfAction) throws IllegalArgumentException;

	public List<TypeOfAction> getAllTipoDeAcoes();
	
	public List<TypeOfAction> findAtivos();

	public TypeOfAction getByIdTypeOfAction(Long id);

}
