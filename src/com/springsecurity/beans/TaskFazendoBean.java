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
public class TaskFazendoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RequestTaskService service;
	private List<RequestTask> listaTarefasFazendo;
	
	public TaskFazendoBean(){
				
	}
	
	@PostConstruct

	public void init() {
		listaTarefasFazendo = service.listarTarefasFazendo();
	}

	public List<RequestTask> getListaTarefasFazendo() {
		return listaTarefasFazendo;
	}

	public void setListaTarefasFazendo(List<RequestTask> listaTarefasFazendo) {
		this.listaTarefasFazendo = listaTarefasFazendo;
	}
	
}
	



