package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.entities.TypeOfSubActivity;

public interface TypeOfSubActivityService {

	void adicionar(TypeOfSubActivity typeOfSubActivity)
			throws IllegalArgumentException;

	void alterar(TypeOfSubActivity typeOfSubActivity) throws IllegalArgumentException;
	
	public List<TypeOfSubActivity> listaSubActivityByActivity (TypeOfActivity typeOfActivity);

	public List<TypeOfSubActivity> getAllTipoDeAtividades();

	public List<TypeOfSubActivity> listarAtividadesAtivas();

	public TypeOfSubActivity getByIdTypeOfSubActivity(Long id);

}
