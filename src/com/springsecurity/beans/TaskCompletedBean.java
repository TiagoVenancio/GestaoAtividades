package com.springsecurity.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.RequestTask;
import com.springsecurity.service.RequestTaskService;

@Controller
@Scope("request")
public class TaskCompletedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RequestTaskService service;
	private List<RequestTask> listaTarefas;

	
	public TaskCompletedBean(){
				
	}
	
	@PostConstruct
	public void init() {
		listaTarefas = service.getAllRequestTasks();
	}

	public List<RequestTask> getListaTarefas() {
		return listaTarefas;
	}


	public void setListaTarefas(List<RequestTask> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}
	
	
	

}
