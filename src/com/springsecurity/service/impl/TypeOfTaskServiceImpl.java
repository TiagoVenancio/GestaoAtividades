package com.springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springsecurity.dao.TypeOfTaskDao;
import com.springsecurity.entities.TypeOfTask;
import com.springsecurity.service.TypeOfTaskService;

@Service
@Transactional
public class TypeOfTaskServiceImpl implements TypeOfTaskService {

	@Autowired
	private TypeOfTaskDao dao;

	@Override
	public void adicionar(TypeOfTask typeOfTask)
			throws IllegalArgumentException {
		dao.adiciona(typeOfTask);

	}

}
