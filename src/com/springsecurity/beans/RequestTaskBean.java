package com.springsecurity.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.RequestTask;
import com.springsecurity.service.RequestTaskService;
import com.springsecurity.service.TypeOfActionService;
import com.springsecurity.service.TypeOfActivityService;
import com.springsecurity.service.TypeOfGroupService;
import com.springsecurity.service.TypeOfPriorityService;
import com.springsecurity.service.TypeOfTaskService;

@Controller
@Scope(value = "session")
public class RequestTaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idGrupoAtendimento;

	@Autowired
	private RequestTaskService tarefaService;
	private List<RequestTask> listaTarefas;
	private RequestTask tarefaSelecionada;
	private TypeOfGroupService taskGrupoSelecionado;
	private TypeOfActivityService taskTipoAtividadeSelecionada;
	private TypeOfTaskService taskTipoTarefaSelecionada;
	private TypeOfActionService taskTipoAcaoSelecionada;
	private TypeOfPriorityService taskTipoPrioridadeSelecionada;

	public RequestTaskBean() {
	}

	@PostConstruct
	public void init() {
		listaTarefas = tarefaService.getAllRequestTasks();
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

	public Long getIdGrupoAtendimento() {
		return idGrupoAtendimento;
	}

	public void setIdGrupoAtendimento(Long idGrupoAtendimento) {
		this.idGrupoAtendimento = idGrupoAtendimento;
	}

	public TypeOfGroupService getTaskGrupoSelecionado() {
		return taskGrupoSelecionado;
	}

	public void setTaskGrupoSelecionado(TypeOfGroupService taskGrupoSelecionado) {
		this.taskGrupoSelecionado = taskGrupoSelecionado;
	}

	public TypeOfActivityService getTaskTipoAtividadeSelecionada() {
		return taskTipoAtividadeSelecionada;
	}

	public void setTaskTipoAtividadeSelecionada(
			TypeOfActivityService taskTipoAtividadeSelecionada) {
		this.taskTipoAtividadeSelecionada = taskTipoAtividadeSelecionada;
	}

	public TypeOfTaskService getTaskTipoTarefaSelecionada() {
		return taskTipoTarefaSelecionada;
	}

	public void setTaskTipoTarefaSelecionada(
			TypeOfTaskService taskTipoTarefaSelecionada) {
		this.taskTipoTarefaSelecionada = taskTipoTarefaSelecionada;
	}

	public TypeOfActionService getTaskTipoAcaoSelecionada() {
		return taskTipoAcaoSelecionada;
	}

	public void setTaskTipoAcaoSelecionada(
			TypeOfActionService taskTipoAcaoSelecionada) {
		this.taskTipoAcaoSelecionada = taskTipoAcaoSelecionada;
	}

	public TypeOfPriorityService getTaskTipoPrioridadeSelecionada() {
		return taskTipoPrioridadeSelecionada;
	}

	public void setTaskTipoPrioridadeSelecionada(
			TypeOfPriorityService taskTipoPrioridadeSelecionada) {
		this.taskTipoPrioridadeSelecionada = taskTipoPrioridadeSelecionada;
	}

}
