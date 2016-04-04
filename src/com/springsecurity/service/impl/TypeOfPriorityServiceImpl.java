package com.springsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.TypeOfPriorityDao;
import com.springsecurity.entities.TypeOfPriority;
import com.springsecurity.service.TypeOfPriorityService;

@Service
@Transactional
public class TypeOfPriorityServiceImpl implements TypeOfPriorityService {

	@Autowired
	TypeOfPriorityDao dao;

	@Override
	public void adicionar(TypeOfPriority typeOfPriority)
			throws IllegalArgumentException {
		dao.save(typeOfPriority);

	}

	@Override
	public List<TypeOfPriority> findAll() {
		return dao.findAll();
	}

	@Override
	public void alterar(TypeOfPriority typeOfPriority)
			throws IllegalArgumentException {
		dao.update(typeOfPriority);

	}

	@Override
	public List<TypeOfPriority> getAllTipoDePrioridades() {
		return dao.findAll();
	}

	@Override
	public TypeOfPriority getByIdTypeOfPriority(Long id) {
		return dao.getById(id);
	}

	@Override
	public List<TypeOfPriority> listarPrioridadesAtivas() {
		return dao.findAllPrioridadesAtivas();
	}

}
