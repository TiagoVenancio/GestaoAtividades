package com.springsecurity.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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

	@Autowired
	private TypeOfTaskService typeOfTaskService;
	private List<TypeOfTask> listaTiposTarefas;
	private TypeOfTask typeOfTaskSelecionada;

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
			listaTiposTarefas = typeOfTaskService.getAllTipoDeTarefas();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
							"Item adicionado com sucesso!"));
			return null;

		} catch (DataAccessException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha!",
							"Item não adicionado!"));
		}
		return null;

	}

	public String alterar() {
		try {
			typeOfTaskSelecionada.setLastUpdate(new Date(System
					.currentTimeMillis()));
			typeOfTaskService.alterar(typeOfTaskSelecionada);
			listaTiposTarefas = typeOfTaskService.getAllTipoDeTarefas();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
							"Item atualizado com sucesso!"));

			return null;

		} catch (DataAccessException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha!",
							"Item não alterado!"));
		}
		return null;

	}

	public List<TypeOfTask> getListaTiposTarefas() {
		return listaTiposTarefas;
	}

	public void setListaTiposTarefas(List<TypeOfTask> listaTiposTarefas) {
		this.listaTiposTarefas = listaTiposTarefas;
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

	public TypeOfTask getTypeOfTaskSelecionada() {
		return typeOfTaskSelecionada;
	}

	public void setTypeOfTaskSelecionada(TypeOfTask typeOfTaskSelecionada) {
		this.typeOfTaskSelecionada = typeOfTaskSelecionada;
	}

}
