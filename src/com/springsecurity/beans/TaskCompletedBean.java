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

		public String pesquisar(){
			try {
				
				service.buscarTaskPor(tarefaSelecionada);
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

		public RequestTaskService getService() {
			return service;
		}

		public void setService(RequestTaskService service) {
			this.service = service;
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
