package com.springsecurity.beans;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.TypeOfTask;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.service.TypeOfTaskService;

@Controller
@Scope("request")
public class TypeOfTaskBean {

	private TypeOfTask typeOfTask;

	private String tipoTarefa;
	private StatusObjectEnum statusObjeto;

	@Autowired
	private TypeOfTaskService typeOfTaskService;

	@PostConstruct
	private void init() {
		typeOfTask = new TypeOfTask();
	}

	public List<TypeOfTask> getList() {
		return typeOfTaskService.getAll();

	}

	public String adicionar() {
		try {
			typeOfTask.setCreateDate(Calendar.getInstance());
			typeOfTask.setLastUpdate(Calendar.getInstance());
			typeOfTask.setDescription(tipoTarefa);
			typeOfTask.setStatusObjectEnum(statusObjeto);
			typeOfTaskService.adicionar(typeOfTask);
			message("Adicionado com sucesso!");
		} catch (Exception e) {
			message(e.getMessage());
		}
		return "";
	}

	public String alterar() {
		try {
			typeOfTask.setLastUpdate(Calendar.getInstance());
			typeOfTask.setDescription(tipoTarefa);
			typeOfTask.setStatusObjectEnum(statusObjeto);
			typeOfTaskService.alterar(typeOfTask);
			message("Alterado com sucesso!");
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

	public String getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(String tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public StatusObjectEnum getStatusObjeto() {
		return statusObjeto;
	}

	public void setStatusObjeto(StatusObjectEnum statusObjeto) {
		this.statusObjeto = statusObjeto;
	}

}
