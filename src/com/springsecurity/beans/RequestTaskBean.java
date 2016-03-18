package com.springsecurity.beans;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.springsecurity.entities.RequestCustomer;
import com.springsecurity.entities.RequestTask;
import com.springsecurity.entities.TypeOfAction;
import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.entities.TypeOfGroup;
import com.springsecurity.entities.TypeOfPriority;
import com.springsecurity.entities.TypeOfTask;

@Controller
@Scope(value = "session")
public class RequestTaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RequestTask requestTask;
	private List<RequestTask> listaRequestTaskService;
	private RequestTask requestTaskSelecionada;
	private List<TypeOfTask> typeOfTaskSelecionada;
	private List<TypeOfAction> typeOfActionSelecionada;
	private List<TypeOfPriority> typeOfPrioritySelecionada;
	private List<TypeOfGroup> typeOfGroupSelecionada;
	private List<TypeOfActivity> typeOfActivitySelecionada;
	private List<RequestCustomer> requestCustomerSelecionada;

	public RequestTask getRequestTask() {
		return requestTask;
	}

	public void setRequestTask(RequestTask requestTask) {
		this.requestTask = requestTask;
	}

	public List<TypeOfTask> getTypeOfTaskSelecionada() {
		return typeOfTaskSelecionada;
	}

	public void setTypeOfTaskSelecionada(List<TypeOfTask> typeOfTaskSelecionada) {
		this.typeOfTaskSelecionada = typeOfTaskSelecionada;
	}

	public List<TypeOfAction> getTypeOfActionSelecionada() {
		return typeOfActionSelecionada;
	}

	public void setTypeOfActionSelecionada(
			List<TypeOfAction> typeOfActionSelecionada) {
		this.typeOfActionSelecionada = typeOfActionSelecionada;
	}

	public List<TypeOfPriority> getTypeOfPrioritySelecionada() {
		return typeOfPrioritySelecionada;
	}

	public void setTypeOfPrioritySelecionada(
			List<TypeOfPriority> typeOfPrioritySelecionada) {
		this.typeOfPrioritySelecionada = typeOfPrioritySelecionada;
	}

	public List<TypeOfGroup> getTypeOfGroupSelecionada() {
		return typeOfGroupSelecionada;
	}

	public void setTypeOfGroupSelecionada(
			List<TypeOfGroup> typeOfGroupSelecionada) {
		this.typeOfGroupSelecionada = typeOfGroupSelecionada;
	}

	public List<TypeOfActivity> getTypeOfActivitySelecionada() {
		return typeOfActivitySelecionada;
	}

	public void setTypeOfActivitySelecionada(
			List<TypeOfActivity> typeOfActivitySelecionada) {
		this.typeOfActivitySelecionada = typeOfActivitySelecionada;
	}

	public List<RequestCustomer> getRequestCustomerSelecionada() {
		return requestCustomerSelecionada;
	}

	public void setRequestCustomerSelecionada(
			List<RequestCustomer> requestCustomerSelecionada) {
		this.requestCustomerSelecionada = requestCustomerSelecionada;
	}

	public RequestTask getRequestTaskSelecionada() {
		return requestTaskSelecionada;
	}

	public void setRequestTaskSelecionada(RequestTask requestTaskSelecionada) {
		this.requestTaskSelecionada = requestTaskSelecionada;
	}

	public List<RequestTask> getListaRequestTaskService() {
		return listaRequestTaskService;
	}

	public void setListaRequestTaskService(
			List<RequestTask> listaRequestTaskService) {
		this.listaRequestTaskService = listaRequestTaskService;
	}

}
