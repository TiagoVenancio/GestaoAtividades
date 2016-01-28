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

import com.springsecurity.entities.TypeOfGroup;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.service.TypeOfGroupService;

@Controller
@Scope(value = "session")
public class TypeOfGroupBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TypeOfGroupService typeOfGroupService;
	private List<TypeOfGroup> listaTiposGrupos;
	private TypeOfGroup typeOfGroupSelecionada;

	private String description;
	private StatusObjectEnum statusObjectEnum;

	public TypeOfGroupBean() {

	}

	@PostConstruct
	public void init() {
		listaTiposGrupos = typeOfGroupService.getAllTipoDeGrupos();

	}

	public String adicionar() {
		try {
			TypeOfGroup typeOfGroup = new TypeOfGroup();
			typeOfGroup.setCreateDate(new Date(System.currentTimeMillis()));
			typeOfGroup.setLastUpdate(new Date(System.currentTimeMillis()));
			typeOfGroup.setDescription(description);
			typeOfGroup.setStatusObjectEnum(statusObjectEnum);
			typeOfGroupService.adicionar(typeOfGroup);
			listaTiposGrupos = typeOfGroupService.getAllTipoDeGrupos();
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
			typeOfGroupSelecionada.setLastUpdate(new Date(System.currentTimeMillis()));
			typeOfGroupService.alterar(typeOfGroupSelecionada);
			listaTiposGrupos = typeOfGroupService.getAllTipoDeGrupos();
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

	public TypeOfGroupService getTypeOfGroupService() {
		return typeOfGroupService;
	}

	public void setTypeOfGroupService(TypeOfGroupService typeOfGroupService) {
		this.typeOfGroupService = typeOfGroupService;
	}

	public List<TypeOfGroup> getListaTiposGrupos() {
		return listaTiposGrupos;
	}

	public void setListaTiposGrupos(List<TypeOfGroup> listaTiposGrupos) {
		this.listaTiposGrupos = listaTiposGrupos;
	}

	public TypeOfGroup getTypeOfGroupSelecionada() {
		return typeOfGroupSelecionada;
	}

	public void setTypeOfGroupSelecionada(TypeOfGroup typeOfGroupSelecionada) {
		this.typeOfGroupSelecionada = typeOfGroupSelecionada;
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
