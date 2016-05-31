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
public class TaskConcluidoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RequestTaskService service;
	private List<RequestTask> listaTarefasConcluido;
	
	public TaskConcluidoBean(){
				
	}
	
	@PostConstruct

	public void init() {
		listaTarefasConcluido = service.listarTarefasConcluido();
	}

	public List<RequestTask> getListaTarefasConcluido() {
		return listaTarefasConcluido;
	}

	public void setListaTarefasConcluido(List<RequestTask> listaTarefasConcluido) {
		this.listaTarefasConcluido = listaTarefasConcluido;
	}

	
}
	



