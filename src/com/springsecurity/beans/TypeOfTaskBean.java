package com.springsecurity.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import com.springsecurity.entities.TypeOfTask;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.service.TypeOfTaskService;

@Controller
@Scope(value = "session")
public class TypeOfTaskBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	@Autowired
	private TypeOfTaskService typeOfTaskService;
	private List<TypeOfTask> listaTiposTarefas;

	private String description;
	private StatusObjectEnum statusObjectEnum;

	public TypeOfTaskBean() {

	}

	@PostConstruct
	public void init() {
		listaTiposTarefas = typeOfTaskService.getAllTipoDeTarefas();

	}

	public String adicionar() {
		try {
			TypeOfTask typeOfTask = new TypeOfTask();
			typeOfTask.setCreateDate(new Date(System.currentTimeMillis()));
			typeOfTask.setLastUpdate(new Date(System.currentTimeMillis()));
			typeOfTask.setDescription(description);
			typeOfTask.setStatusObjectEnum(statusObjectEnum);
			typeOfTaskService.adicionar(typeOfTask);
			return SUCCESS;

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ERROR;

	}

	public String alterar() {
		try {
			TypeOfTask typeOfTask = new TypeOfTask();
			typeOfTask.setLastUpdate(new Date(System.currentTimeMillis()));
			typeOfTask.setDescription(description);
			typeOfTask.setStatusObjectEnum(statusObjectEnum);
			typeOfTaskService.alterar(typeOfTask);
			return SUCCESS;

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ERROR;

	}

	public List<TypeOfTask> getListaTiposTarefas() {
		return listaTiposTarefas;
	}

	public void setListaTiposTarefas(List<TypeOfTask> listaTiposTarefas) {
		this.listaTiposTarefas = listaTiposTarefas;
	}

	public static String getSuccess() {
		return SUCCESS;
	}

	public static String getError() {
		return ERROR;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

}
