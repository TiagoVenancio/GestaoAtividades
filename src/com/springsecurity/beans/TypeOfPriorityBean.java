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
import com.springsecurity.entities.TypeOfPriority;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.service.TypeOfPriorityService;

@Controller
@Scope(value = "session")
public class TypeOfPriorityBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TypeOfPriorityService typeOfPriorityService;
	private List<TypeOfPriority> listaTiposPrioridades;
	private TypeOfPriority typeOfPrioritySelecionada;

	private String description;
	private StatusObjectEnum statusObjectEnum;

	public TypeOfPriorityBean() {

	}

	@PostConstruct
	public void init() {
		listaTiposPrioridades = typeOfPriorityService.getAllTipoDePrioridades();

	}

	public String adicionar() {
		try {
			TypeOfPriority typeOfPriority = new TypeOfPriority();
			typeOfPriority.setCreateDate(new Date(System.currentTimeMillis()));
			typeOfPriority.setLastUpdate(new Date(System.currentTimeMillis()));
			typeOfPriority.setDescription(description);
			typeOfPriority.setStatusObjectEnum(StatusObjectEnum.Ativo);
			typeOfPriorityService.adicionar(typeOfPriority);
			listaTiposPrioridades = typeOfPriorityService
					.getAllTipoDePrioridades();
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
			typeOfPrioritySelecionada.setLastUpdate(new Date(System
					.currentTimeMillis()));
			typeOfPriorityService.alterar(typeOfPrioritySelecionada);
			listaTiposPrioridades = typeOfPriorityService
					.getAllTipoDePrioridades();
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

	public TypeOfPriorityService getTypeOfPriorityService() {
		return typeOfPriorityService;
	}

	public void setTypeOfPriorityService(
			TypeOfPriorityService typeOfPriorityService) {
		this.typeOfPriorityService = typeOfPriorityService;
	}

	public List<TypeOfPriority> getListaTiposPrioridades() {
		return listaTiposPrioridades;
	}

	public void setListaTiposPrioridades(
			List<TypeOfPriority> listaTiposPrioridades) {
		this.listaTiposPrioridades = listaTiposPrioridades;
	}

	public TypeOfPriority getTypeOfPrioritySelecionada() {
		return typeOfPrioritySelecionada;
	}

	public void setTypeOfPrioritySelecionada(
			TypeOfPriority typeOfPrioritySelecionada) {
		this.typeOfPrioritySelecionada = typeOfPrioritySelecionada;
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