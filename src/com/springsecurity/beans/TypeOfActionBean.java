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

import com.springsecurity.entities.TypeOfAction;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.service.TypeOfActionService;

@Controller
@Scope(value = "session")
public class TypeOfActionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TypeOfActionService typeOfActionService;
	private List<TypeOfAction> listaTiposAcoes;
	private TypeOfAction typeOfActionkSelecionada;

	private String description;
	private StatusObjectEnum statusObjectEnum;
	
	public TypeOfActionBean() {

	}
	
	@PostConstruct
	public void init() {
		listaTiposAcoes = typeOfActionService.getAllTipoDeAcoes();

	}

	public String adicionar() {
		try {
			TypeOfAction TypeOfAction = new TypeOfAction();
			TypeOfAction.setCreateDate(new Date(System.currentTimeMillis()));
			TypeOfAction.setLastUpdate(new Date(System.currentTimeMillis()));
			TypeOfAction.setDescription(description);
			TypeOfAction.setStatusObjectEnum(statusObjectEnum);
			typeOfActionService.adicionar(TypeOfAction);
			listaTiposAcoes = typeOfActionService.getAllTipoDeAcoes();
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
			typeOfActionkSelecionada.setLastUpdate(new Date(System
					.currentTimeMillis()));
			typeOfActionService.alterar(typeOfActionkSelecionada);
			listaTiposAcoes = typeOfActionService.getAllTipoDeAcoes();
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

	public TypeOfActionService getTypeOfActionService() {
		return typeOfActionService;
	}

	public void setTypeOfActionService(TypeOfActionService typeOfActionService) {
		this.typeOfActionService = typeOfActionService;
	}

	public List<TypeOfAction> getListaTiposAcoes() {
		return listaTiposAcoes;
	}

	public void setListaTiposAcoes(List<TypeOfAction> listaTiposAcoes) {
		this.listaTiposAcoes = listaTiposAcoes;
	}

	public TypeOfAction getTypeOfActionkSelecionada() {
		return typeOfActionkSelecionada;
	}

	public void setTypeOfActionkSelecionada(TypeOfAction typeOfActionkSelecionada) {
		this.typeOfActionkSelecionada = typeOfActionkSelecionada;
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
