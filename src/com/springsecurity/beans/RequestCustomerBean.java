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
public class RequestCustomerBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RequestCustomerService requestCustomerService;
	private List<RequestCustomer> listaRequestCustomerService;
	private RequestCustomer requestCustomerSelecionada;
	
	private String matriculaSolicitante;
	private String nameSolicitante;
	private String emailSolicitante;
	
	private static String USERNAMEL_LOGADO = System.getProperty("user.name");
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
			RequestCustomer.setUserId(matriculaSolicitante);
			RequestCustomer.setUserName(nameSolicitante);
			RequestCustomer.setEmail(emailSolicitante);
			RequestCustomer.setLastUserChange(USERNAMEL_LOGADO);
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

	public RequestCustomer getRequestCustomerSelecionada() {
		return requestCustomerSelecionada;
	}

	public void setRequestCustomerSelecionada(
			RequestCustomer requestCustomerSelecionada) {
		this.requestCustomerSelecionada = requestCustomerSelecionada;
	}

	public String getMatriculaSolicitante() {
		return matriculaSolicitante;
	}

	public void setMatriculaSolicitante(String matriculaSolicitante) {
		this.matriculaSolicitante = matriculaSolicitante;
	}

	public String getNameSolicitante() {
		return nameSolicitante;
	}

	public void setNameSolicitante(String nameSolicitante) {
		this.nameSolicitante = nameSolicitante;
	}

	public String getEmailSolicitante() {
		return emailSolicitante;
	}

	public void setEmailSolicitante(String emailSolicitante) {
		this.emailSolicitante = emailSolicitante;
	}

	public static String getUSERNAMEL_LOGADO() {
		return USERNAMEL_LOGADO;
	}

	public static void setUSERNAMEL_LOGADO(String uSERNAMEL_LOGADO) {
		USERNAMEL_LOGADO = uSERNAMEL_LOGADO;
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
