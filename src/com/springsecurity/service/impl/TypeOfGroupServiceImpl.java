package com.springsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.TypeOfGroupDao;
import com.springsecurity.entities.TypeOfGroup;
import com.springsecurity.service.TypeOfGroupService;

@Service
@Transactional
public class TypeOfGroupServiceImpl implements TypeOfGroupService {

	@Autowired
	TypeOfGroupDao dao;

	@Override
	public void adicionar(TypeOfGroup typeOfGroup)
			throws IllegalArgumentException {
		dao.save(typeOfGroup);

	}

	@Override
	public void alterar(TypeOfGroup typeOfGroup)
			throws IllegalArgumentException {
		dao.update(typeOfGroup);

	}

	@Override
	public List<TypeOfGroup> getAll() {
		return dao.findAll();
	}

	@Override
	public TypeOfGroup getByIdTypeOfGroup(Long id) {
		return dao.getById(id);
	}

}
