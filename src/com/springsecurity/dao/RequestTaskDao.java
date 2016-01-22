package com.springsecurity.dao;

import java.util.List;
import com.springsecurity.entities.RequestTask;

public interface RequestTaskDao {

	List<RequestTask> findAll();

	void save(RequestTask requestTask);

	void update(RequestTask requestTask);

	RequestTask getById(Long id);

}
