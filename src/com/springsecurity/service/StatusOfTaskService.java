package com.springsecurity.service;

import java.util.List;
import com.springsecurity.entities.StatusOfTask;

public interface StatusOfTaskService {

	void adicionar(StatusOfTask statusOfTask) throws IllegalArgumentException;

	List<StatusOfTask> findAll();

}
