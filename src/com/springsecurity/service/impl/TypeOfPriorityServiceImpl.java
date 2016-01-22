package com.springsecurity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springsecurity.dao.TypeOfPriorityDao;
import com.springsecurity.entities.TypeOfPriority;
import com.springsecurity.entities.TypeOfTask;
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
	public List<TypeOfTask> findAll() {
		return findAll();
	}

}
