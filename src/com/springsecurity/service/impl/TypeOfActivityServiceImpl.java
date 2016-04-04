package com.springsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.TypeOfActivityDao;
import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.service.TypeOfActivityService;

@Service
@Transactional
public class TypeOfActivityServiceImpl implements TypeOfActivityService {

	@Autowired
	TypeOfActivityDao dao;

	@Override
	public void adicionar(TypeOfActivity typeOfActivity)
			throws IllegalArgumentException {
		dao.save(typeOfActivity);

	}

	@Override
	public void alterar(TypeOfActivity typeOfActivity)
			throws IllegalArgumentException {
		dao.update(typeOfActivity);

	}

	@Override
	public List<TypeOfActivity> getAllTipoDeAtividades() {
		return dao.findAll();
	}

	@Override
	public TypeOfActivity getByIdTypeOfActivity(Long id) {
		return dao.getById(id);
	}

	@Override
	public List<TypeOfActivity> listarAtividadesAtivas() {
		return dao.findAllActivityAtivas();
	}

}
