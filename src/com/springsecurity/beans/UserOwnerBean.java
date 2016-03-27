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

import com.springsecurity.entities.UserOwnerTask;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.service.UserOwnerTaskService;

@Controller
@Scope("session")
public class UserOwnerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserOwnerTaskService userService;
	private List<UserOwnerTask> listaUsuarios;
	private UserOwnerTask userOwnerTaskSelecionado;

	private String nameUser;
	private String registroUser;
	private String emailUser;
	private String groupUser;

	public UserOwnerBean() {

	}

	@PostConstruct
	public void init() {

		listaUsuarios = userService.getAll();

	}

	public String adicionar() {
		try {
			UserOwnerTask userOwnerTask = new UserOwnerTask();
			userOwnerTask.setBusinessGroup(groupUser);
			userOwnerTask.setDateCreate(new Date(System.currentTimeMillis()));
			userOwnerTask.setLastUpdate(new Date(System.currentTimeMillis()));
			userOwnerTask.setEmail(emailUser);
			userOwnerTask.setName(nameUser);
			userOwnerTask.setUsername(registroUser);
			userOwnerTask.setStatusObjectEnum(StatusObjectEnum.Ativo);

			userService.adicionar(userOwnerTask);
			listaUsuarios = userService.getAll();

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
			userOwnerTaskSelecionado.setLastUpdate(new Date(System
					.currentTimeMillis()));
			userService.alterar(userOwnerTaskSelecionado);
			listaUsuarios = userService.getAll();
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

	public List<UserOwnerTask> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UserOwnerTask> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public UserOwnerTask getUserOwnerTaskSelecionado() {
		return userOwnerTaskSelecionado;
	}

	public void setUserOwnerTaskSelecionado(
			UserOwnerTask userOwnerTaskSelecionado) {
		this.userOwnerTaskSelecionado = userOwnerTaskSelecionado;
	}

	public UserOwnerTaskService getUserService() {
		return userService;
	}

	public void setUserService(UserOwnerTaskService userService) {
		this.userService = userService;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getRegistroUser() {
		return registroUser;
	}

	public void setRegistroUser(String registroUser) {
		this.registroUser = registroUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getGroupUser() {
		return groupUser;
	}

	public void setGroupUser(String groupUser) {
		this.groupUser = groupUser;
	}

}
