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
public class TaskAfazerBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RequestTaskService service;
	private List<RequestTask> listaTarefasAfazer;
	
	public TaskAfazerBean(){
				
	}
	
	@PostConstruct

	public void init() {
		listaTarefasAfazer = service.listarTarefasAFazer();
	}

	public List<RequestTask> getListaTarefasAfazer() {
		return listaTarefasAfazer;
	}

	public void setListaTarefasAfazer(List<RequestTask> listaTarefasAfazer) {
		this.listaTarefasAfazer = listaTarefasAfazer;
	}
	
}
	



