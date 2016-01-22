package com.springsecurity.service;

import java.util.List;
import com.springsecurity.entities.TypeOfAction;

public interface TypeOfActionService {

	void adicionar(TypeOfAction typeOfAction) throws IllegalArgumentException;

	List<TypeOfAction> findAll();

}
