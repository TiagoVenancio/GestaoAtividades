package com.springsecurity.dao;

import java.util.List;
import com.springsecurity.entities.StatusOfTask;

public interface StatusOfTaskDao {

	List<StatusOfTask> findAll();

	void save(StatusOfTask statusOfTask);

	void update(StatusOfTask statusOfTask);

	StatusOfTask getById(Long id);

}
