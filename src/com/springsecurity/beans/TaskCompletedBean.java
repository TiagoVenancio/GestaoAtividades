package com.springsecurity.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
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
	private RequestTask tarefaSelecionada;
	
	public TaskCompletedBean(){
				
	}
	
	@PostConstruct
	public void init() {
		tarefaSelecionada = new RequestTask();
		
	}
	
	public void buscaAll() {
		listaTarefas = service.getAllRequestTasks();
	}
	
	public void pesquisarFiltros(){
		
		listaTarefas = service.findForFiltros("USER_OWNER_ID", String.valueOf(tarefaSelecionada.getUserOwnerTask().getId()));
	}

		public String pesquisar(){
			try {
				
				service.buscarTaskPor(tarefaSelecionada.getUserOwnerTask().getId());
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
								"Item adicionado com sucesso!");
				return "Sucesso";

			} catch (DataAccessException e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha!",
								"Item não adicionado!"));
			}
			return null;

		
		}

		public List<RequestTask> getListaTarefas() {
			return listaTarefas;
		}

		public void setListaTarefas(List<RequestTask> listaTarefas) {
			this.listaTarefas = listaTarefas;
		}

		public RequestTask getTarefaSelecionada() {
			return tarefaSelecionada;
		}

		public void setTarefaSelecionada(RequestTask tarefaSelecionada) {
			this.tarefaSelecionada = tarefaSelecionada;
		}
		
		
}
