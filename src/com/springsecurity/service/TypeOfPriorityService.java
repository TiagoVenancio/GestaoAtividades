package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entities.TypeOfPriority;
import com.springsecurity.entities.TypeOfTask;

public interface TypeOfPriorityService {
	
	void adicionar(TypeOfPriority typeOfPriority) throws IllegalArgumentException;
	
	List<TypeOfTask> findAll();

}
