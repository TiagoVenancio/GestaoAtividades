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

import com.springsecurity.entities.TypeOfSubActivity;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.service.TypeOfSubActivityService;

@Controller
@Scope("session")
public class TypeOfSubActivityBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TypeOfSubActivityService typeOfSubActivityService;
	private List<TypeOfSubActivity> listaTiposAtividades;
	private TypeOfSubActivity typeOfSubActivitySelecionada;
	

	private String description;
	private StatusObjectEnum statusObjectEnum;

	public TypeOfSubActivityBean() {
		typeOfSubActivitySelecionada = new TypeOfSubActivity();
	}

	@PostConstruct
	public void init() {
		listaTiposAtividades = typeOfSubActivityService.getAllTipoDeAtividades();
	}

	public String adicionar() {
		try {
			
			typeOfSubActivitySelecionada.setCreateDate(new Date(System.currentTimeMillis()));
			typeOfSubActivitySelecionada.setLastUpdate(new Date(System.currentTimeMillis()));
			typeOfSubActivitySelecionada.setStatusObjectEnum(StatusObjectEnum.Ativo);
			typeOfSubActivityService.adicionar(typeOfSubActivitySelecionada);
			listaTiposAtividades = typeOfSubActivityService.getAllTipoDeAtividades();
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
			typeOfSubActivitySelecionada.setLastUpdate(new Date(System.currentTimeMillis()));
			typeOfSubActivityService.alterar(typeOfSubActivitySelecionada);
			listaTiposAtividades = typeOfSubActivityService
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

	public TypeOfSubActivityService getTypeOfSubActivityService() {
		return typeOfSubActivityService;
	}

	public void setTypeOfSubActivityService(
			TypeOfSubActivityService typeOfSubActivityService) {
		this.typeOfSubActivityService = typeOfSubActivityService;
	}

	public List<TypeOfSubActivity> getListaTiposAtividades() {
		return listaTiposAtividades;
	}

	public void setListaTiposAtividades(List<TypeOfSubActivity> listaTiposAtividades) {
		this.listaTiposAtividades = listaTiposAtividades;
	}

	public TypeOfSubActivity getTypeOfSubActivitySelecionada() {
		return typeOfSubActivitySelecionada;
	}

	public void setTypeOfSubActivitySelecionada(
			TypeOfSubActivity typeOfSubActivitySelecionada) {
		this.typeOfSubActivitySelecionada = typeOfSubActivitySelecionada;
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
