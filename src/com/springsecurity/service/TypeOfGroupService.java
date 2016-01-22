package com.springsecurity.service;

import java.util.List;
import com.springsecurity.entities.TypeOfGroup;

public interface TypeOfGroupService {

	void adicionar(TypeOfGroup typeOfGroup) throws IllegalArgumentException;

	List<TypeOfGroup> findAll();

}
