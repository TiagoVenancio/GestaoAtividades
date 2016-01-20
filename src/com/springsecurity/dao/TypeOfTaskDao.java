package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.entities.TypeOfTask;

public interface TypeOfTaskDao {

	TypeOfTask buscaPorId(Long id);

	List<TypeOfTask> lista();

	void adiciona(TypeOfTask t);

	void altera(TypeOfTask t);

}
