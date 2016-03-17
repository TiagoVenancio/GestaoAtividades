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

import com.springsecurity.entities.RequestCustomer;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.service.RequestCustomerService;

@Controller
@Scope(value = "session")
public class RequestCustomerBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RequestCustomerService requestCustomerService;
	private List<RequestCustomer> listaRequestCustomerService;
	private RequestCustomer requestCustomerSelecionada;
	
	private String username;
	private String name;
	private String email;
	
	private static String USERNAME = System.getProperty("user.name");
	private StatusObjectEnum statusObjectEnum;
	
	public RequestCustomerBean(){
					
	}
	
	@PostConstruct
	public void init() {
		listaRequestCustomerService = requestCustomerService.getAllRequestCustomers();

	}

	public String adicionar() {
		try {
			RequestCustomer RequestCustomer = new RequestCustomer();
			RequestCustomer.setCreateDate(new Date(System.currentTimeMillis()));
			RequestCustomer.setLastUpdate(new Date(System.currentTimeMillis()));
			RequestCustomer.setUserName(username);
			RequestCustomer.setName(name);
			RequestCustomer.setEmail(email);
			RequestCustomer.setLastUserChange(USERNAME);
			RequestCustomer.setStatusObjectEnum(statusObjectEnum);
			requestCustomerService.adicionar(RequestCustomer);
			listaRequestCustomerService = requestCustomerService.getAllRequestCustomers();
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
			requestCustomerSelecionada.setLastUpdate(new Date(System
					.currentTimeMillis()));
			requestCustomerService.alterar(requestCustomerSelecionada);
			listaRequestCustomerService = requestCustomerService.getAllRequestCustomers();
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

	public RequestCustomerService getRequestCustomerService() {
		return requestCustomerService;
	}

	public void setRequestCustomerService(
			RequestCustomerService requestCustomerService) {
		this.requestCustomerService = requestCustomerService;
	}

	public List<RequestCustomer> getListaRequestCustomerService() {
		return listaRequestCustomerService;
	}

	public void setListaRequestCustomerService(
			List<RequestCustomer> listaRequestCustomerService) {
		this.listaRequestCustomerService = listaRequestCustomerService;
	}

	public RequestCustomer getRequestCustomer() {
		return requestCustomerSelecionada;
	}

	public void setRequestCustomer(RequestCustomer requestCustomer) {
		this.requestCustomerSelecionada = requestCustomer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static String getUSERNAME() {
		return USERNAME;
	}

	public static void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
