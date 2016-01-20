package com.springsecurity.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.TypeOfTask;
import com.springsecurity.service.TypeOfTaskService;

@Controller
@Scope("request")
public class TypeOfTaskBean {

	private TypeOfTask typeOfTask;

	@Autowired
	private TypeOfTaskService service;

	@PostConstruct
	private void init() {
		typeOfTask = new TypeOfTask();
	}

	public String adicionar() {
		try {
			service.adicionar(typeOfTask);
			message("Adicionado com sucesso!");
		} catch (Exception e) {
			message(e.getMessage());
		}
		return "";
	}

	private void message(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(msg, ""));
	}

	public TypeOfTask getTypeOfTask() {
		return typeOfTask;
	}

	public void setTypeOfTask(TypeOfTask typeOfTask) {
		this.typeOfTask = typeOfTask;
	}

}
