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

import com.springsecurity.entities.RequestTask;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.enums.StatusTaskEnum;
import com.springsecurity.service.RequestTaskService;

@Controller
@Scope("request")
public class RequestTaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RequestTaskService tarefaService;
	private List<RequestTask> listaTarefas;
	private RequestTask tarefaSelecionada;

	public RequestTaskBean() {
	}

	@PostConstruct
	public void init() {
		listaTarefas = tarefaService.getAllRequestTasks();
		tarefaSelecionada = new RequestTask();

	}

	public String incluirFila() {
		try {
			tarefaSelecionada
					.setCreateDate(new Date(System.currentTimeMillis()));
			tarefaSelecionada.setStatusObjectEnum(StatusObjectEnum.Ativo);
			tarefaSelecionada.setStatusTaskEnum(StatusTaskEnum.A_FAZER);
			tarefaService.adicionar(tarefaSelecionada);
			listaTarefas = tarefaService.getAllRequestTasks();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
							"Item adicionado com sucesso!"));
			return "tarefasPendentes";

		} catch (DataAccessException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha!",
							"Item não adicionado!"));
		}
		return null;

	}

	public String executar() {
		try {
			tarefaSelecionada
					.setCreateDate(new Date(System.currentTimeMillis()));
			tarefaSelecionada.setStatusObjectEnum(StatusObjectEnum.Ativo);
			tarefaSelecionada.setStatusTaskEnum(StatusTaskEnum.FAZENDO);
			tarefaService.adicionar(tarefaSelecionada);
			listaTarefas = tarefaService.getAllRequestTasks();
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

	public String concluir() {
		try {
			tarefaSelecionada
					.setCreateDate(new Date(System.currentTimeMillis()));
			tarefaSelecionada
					.setCloseDate(new Date(System.currentTimeMillis()));
			tarefaSelecionada.setStatusObjectEnum(StatusObjectEnum.Inativo);
			tarefaSelecionada.setStatusTaskEnum(StatusTaskEnum.CONCLUIDA);
			listaTarefas = tarefaService.getAllRequestTasks();
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

	public String cancelar() {
		try {
			tarefaSelecionada
					.setCreateDate(new Date(System.currentTimeMillis()));
			tarefaSelecionada
					.setCloseDate(new Date(System.currentTimeMillis()));
			tarefaSelecionada.setStatusObjectEnum(StatusObjectEnum.Inativo);
			tarefaSelecionada.setStatusTaskEnum(StatusTaskEnum.CANCELADA);
			tarefaService.adicionar(tarefaSelecionada);
			listaTarefas = tarefaService.getAllRequestTasks();
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

	public RequestTaskService getTarefaService() {
		return tarefaService;
	}

	public void setTarefaService(RequestTaskService tarefaService) {
		this.tarefaService = tarefaService;
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