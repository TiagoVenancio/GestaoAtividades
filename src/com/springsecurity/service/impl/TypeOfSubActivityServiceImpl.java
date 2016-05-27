package com.springsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.TypeOfSubActivityDao;
import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.entities.TypeOfSubActivity;
import com.springsecurity.service.TypeOfSubActivityService;

@Service
@Transactional
public class TypeOfSubActivityServiceImpl implements TypeOfSubActivityService {

	@Autowired
	TypeOfSubActivityDao dao;

	@Override
	public void adicionar(TypeOfSubActivity typeOfSubActivity)
			throws IllegalArgumentException {
		dao.save(typeOfSubActivity);

	}

	@Override
	public void alterar(TypeOfSubActivity typeOfSubActivity)
			throws IllegalArgumentException {
		dao.update(typeOfSubActivity);

	}

	@Override
	public List<TypeOfSubActivity> getAllTipoDeAtividades() {
		return dao.findAll();
	}

	@Override
	public TypeOfSubActivity getByIdTypeOfSubActivity(Long id) {
		return dao.getById(id);
	}

	@Override
	public List<TypeOfSubActivity> listarAtividadesAtivas() {
		return dao.findAllActivityAtivas();
	}

	@Override
	public List<TypeOfSubActivity> listaSubActivityByActivity(
			TypeOfActivity typeOfActivity) {
		return dao.listaSubActivityByActivity(typeOfActivity);
	}

}
