package com.springsecurity.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.TypeOfTask;
import com.springsecurity.service.TypeOfTaskService;

@Controller
@Scope("request")
public class TypeOfTaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{typeOfTaskService}")
	private TypeOfTaskService typeOfTaskService;

	private List<TypeOfTask> typeOfTasks;

	@PostConstruct
	public void loadTypeOfTasks() {
		typeOfTasks = typeOfTaskService.findAll();

	}

	public List<TypeOfTask> getTypeOfTasks() {
		return typeOfTasks;
	}

	public void setTypeOfTaskService(TypeOfTaskService typeOfTaskService) {
		this.typeOfTaskService = typeOfTaskService;
	}

}
