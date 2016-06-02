package com.springsecurity.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.RequestCustomer;
import com.springsecurity.entities.TypeOfAction;
import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.entities.TypeOfPriority;
import com.springsecurity.entities.TypeOfSubActivity;
import com.springsecurity.entities.UserOwnerTask;
import com.springsecurity.service.RequestCustomerService;
import com.springsecurity.service.TypeOfActionService;
import com.springsecurity.service.TypeOfActivityService;
import com.springsecurity.service.TypeOfPriorityService;
import com.springsecurity.service.TypeOfSubActivityService;
import com.springsecurity.service.UserOwnerTaskService;

@Controller
@Scope("request")
public class ListsActivesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RequestCustomerService requestCustomerService;
	private List<RequestCustomer> requestCustomerLista;
	
	@Autowired
	private TypeOfActionService typeOfActionService;
	private List<TypeOfAction> typeOfActionLista;
	
	@Autowired
	private TypeOfPriorityService typeOfPriorityService;
	private List<TypeOfPriority> typeOfPriorityLista;
	
	@Autowired
	private UserOwnerTaskService userOwnerTaskService;
	private List<UserOwnerTask> userOwnerTaskLista;
	
	@Autowired
	private TypeOfActivityService typeOfActivityService;
	private List<TypeOfActivity> typeOfActivityLista;
	
	@Autowired
	private TypeOfSubActivityService typeOfSubActivityService;
	private List<TypeOfSubActivity> typeOfSubActivityLista;
	
	

	public ListsActivesBean() {
	}


	@PostConstruct
	public void init() {
		
		requestCustomerLista = requestCustomerService.findAtivos();
		typeOfActionLista = typeOfActionService.findAtivos();
		typeOfPriorityLista = typeOfPriorityService.findAtivos();
		userOwnerTaskLista = userOwnerTaskService.findAtivos();
		typeOfActivityLista = typeOfActivityService.findAtivos();
		typeOfSubActivityLista = typeOfSubActivityService.findAtivos();
		
	}
	
	public List<RequestCustomer> getRequestCustomerLista() {
		return requestCustomerLista;
	}



	public void setRequestCustomerLista(List<RequestCustomer> requestCustomerLista) {
		this.requestCustomerLista = requestCustomerLista;
	}



	public List<TypeOfAction> getTypeOfActionLista() {
		return typeOfActionLista;
	}



	public void setTypeOfActionLista(List<TypeOfAction> typeOfActionLista) {
		this.typeOfActionLista = typeOfActionLista;
	}



	public List<TypeOfPriority> getTypeOfPriorityLista() {
		return typeOfPriorityLista;
	}



	public void setTypeOfPriorityLista(List<TypeOfPriority> typeOfPriorityLista) {
		this.typeOfPriorityLista = typeOfPriorityLista;
	}



	public List<UserOwnerTask> getUserOwnerTaskLista() {
		return userOwnerTaskLista;
	}



	public void setUserOwnerTaskLista(List<UserOwnerTask> userOwnerTaskLista) {
		this.userOwnerTaskLista = userOwnerTaskLista;
	}



	public List<TypeOfActivity> getTypeOfActivityLista() {
		return typeOfActivityLista;
	}



	public void setTypeOfActivityLista(List<TypeOfActivity> typeOfActivityLista) {
		this.typeOfActivityLista = typeOfActivityLista;
	}



	public List<TypeOfSubActivity> getTypeOfSubActivityLista() {
		return typeOfSubActivityLista;
	}



	public void setTypeOfSubActivityLista(
			List<TypeOfSubActivity> typeOfSubActivityLista) {
		this.typeOfSubActivityLista = typeOfSubActivityLista;
	}

}