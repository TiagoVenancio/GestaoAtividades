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
	public List<TypeOfActivity> findAll() {
		return findAll();
	}

}
