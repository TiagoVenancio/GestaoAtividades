package com.springsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springsecurity.dao.TypeOfActionDao;
import com.springsecurity.entities.TypeOfAction;
import com.springsecurity.service.TypeOfActionService;

@Service
@Transactional
public class TypeOfActionServiceImpl implements TypeOfActionService {

	@Autowired
	TypeOfActionDao dao;

	@Override
	public void adicionar(TypeOfAction typeOfAction)
			throws IllegalArgumentException {
		dao.save(typeOfAction);

	}

	@Override
	public List<TypeOfAction> findAll() {
		return findAll();
	}

}
