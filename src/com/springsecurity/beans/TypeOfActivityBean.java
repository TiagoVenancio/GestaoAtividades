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

import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.service.TypeOfActivityService;

@Controller
@Scope(value = "session")
public class TypeOfActivityBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TypeOfActivityService typeOfActivityService;
	private List<TypeOfActivity> listaTiposAtividades;
	private TypeOfActivity typeOfActivitySelecionada;

	private String description;
	private StatusObjectEnum statusObjectEnum;
	

	public TypeOfActivityBean() {

	}

	@PostConstruct
	public void init() {
		listaTiposAtividades = typeOfActivityService.getAllTipoDeAtividades();
	}

	public String adicionar() {
		try {
			
			

			TypeOfActivity TypeOfActivity = new TypeOfActivity();
			TypeOfActivity.setCreateDate(new Date(System.currentTimeMillis()));
			TypeOfActivity.setLastUpdate(new Date(System.currentTimeMillis()));
			TypeOfActivity.setDescription(description);	
			TypeOfActivity.setStatusObjectEnum(statusObjectEnum);
			typeOfActivityService.adicionar(TypeOfActivity);
			listaTiposAtividades = typeOfActivityService
					.getAllTipoDeAtividades();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
							"Item adicionado com sucesso!"));
			return "Sucesso";

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
			typeOfActivitySelecionada.setLastUpdate(new Date(System
					.currentTimeMillis()));
			typeOfActivityService.alterar(typeOfActivitySelecionada);
			listaTiposAtividades = typeOfActivityService
					.getAllTipoDeAtividades();
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

	public TypeOfActivityService getTypeOfActivityService() {
		return typeOfActivityService;
	}

	public void setTypeOfActivityService(
			TypeOfActivityService typeOfActivityService) {
		this.typeOfActivityService = typeOfActivityService;
	}

	public List<TypeOfActivity> getListaTiposAtividades() {
		return listaTiposAtividades;
	}

	public void setListaTiposAtividades(
			List<TypeOfActivity> listaTiposAtividades) {
		this.listaTiposAtividades = listaTiposAtividades;
	}

	public TypeOfActivity getTypeOfActivitySelecionada() {
		return typeOfActivitySelecionada;
	}

	public void setTypeOfActivitySelecionada(
			TypeOfActivity typeOfActivitySelecionada) {
		this.typeOfActivitySelecionada = typeOfActivitySelecionada;
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
