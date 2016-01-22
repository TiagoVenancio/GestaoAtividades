package com.springsecurity.service;

import java.util.List;
import com.springsecurity.entities.TypeOfActivity;

public interface TypeOfActivityService {

	void adicionar(TypeOfActivity typeOfActivity) throws IllegalArgumentException;

	List<TypeOfActivity> findAll();

}
