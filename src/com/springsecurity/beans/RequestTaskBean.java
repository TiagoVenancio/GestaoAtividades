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

import com.springsecurity.entities.RequestCustomer;
import com.springsecurity.entities.RequestTask;
import com.springsecurity.entities.TypeOfAction;
import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.entities.TypeOfGroup;
import com.springsecurity.entities.TypeOfPriority;
import com.springsecurity.entities.TypeOfTask;
import com.springsecurity.entities.User;
import com.springsecurity.enums.StatusObjectEnum;
import com.springsecurity.enums.StatusTaskEnum;
import com.springsecurity.service.RequestTaskService;

@Controller
@Scope(value = "session")
public class RequestTaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date dataInicio;
	private Date dataFinal;
	private Date qtdaHoras;
	private String resumo;
	private String observacao;

	@Autowired
	private RequestTaskService tarefaService;
	private List<RequestTask> listaTarefas;
	private RequestTask tarefaSelecionada;
	private TypeOfGroup taskGrupoSelecionado;
	private TypeOfActivity taskTipoAtividadeSelecionada;
	private TypeOfTask taskTipoTarefaSelecionada;
	private TypeOfAction taskTipoAcaoSelecionada;
	private TypeOfPriority taskTipoPrioridadeSelecionada;
	private RequestCustomer taskClienteSelecionado;
	private User userSelecionado;

	public RequestTaskBean() {
	}

	@PostConstruct
	public void init() {
		listaTarefas = tarefaService.getAllRequestTasks();
	}

	public String adicionar() {
		try {
			RequestTask task = new RequestTask();
			task.setCreateDate(new Date(System.currentTimeMillis()));
			task.setStartDate(dataInicio);
			task.setConclusionDate(dataFinal);
			task.setAmountHours(qtdaHoras);
			task.setStatusObjectEnum(StatusObjectEnum.Ativo);
			task.setStatusTaskEnum(StatusTaskEnum.A_FAZER);
			task.setDescription(observacao);
			task.setResume(resumo);
			task.setTypeOfAction(taskTipoAcaoSelecionada);
			task.setTypeOfActivity(taskTipoAtividadeSelecionada);
			task.setTypeOfGroup(taskGrupoSelecionado);
			task.setTypeOfPriority(taskTipoPrioridadeSelecionada);
			task.setTypeOfTask(taskTipoTarefaSelecionada);
			task.setUser(userSelecionado);
			tarefaService.adicionar(task);
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

	public TypeOfGroup getTaskGrupoSelecionado() {
		return taskGrupoSelecionado;
	}

	public void setTaskGrupoSelecionado(TypeOfGroup taskGrupoSelecionado) {
		this.taskGrupoSelecionado = taskGrupoSelecionado;
	}

	public TypeOfActivity getTaskTipoAtividadeSelecionada() {
		return taskTipoAtividadeSelecionada;
	}

	public void setTaskTipoAtividadeSelecionada(
			TypeOfActivity taskTipoAtividadeSelecionada) {
		this.taskTipoAtividadeSelecionada = taskTipoAtividadeSelecionada;
	}

	public TypeOfTask getTaskTipoTarefaSelecionada() {
		return taskTipoTarefaSelecionada;
	}

	public void setTaskTipoTarefaSelecionada(
			TypeOfTask taskTipoTarefaSelecionada) {
		this.taskTipoTarefaSelecionada = taskTipoTarefaSelecionada;
	}

	public TypeOfPriority getTaskTipoPrioridadeSelecionada() {
		return taskTipoPrioridadeSelecionada;
	}

	public void setTaskTipoPrioridadeSelecionada(
			TypeOfPriority taskTipoPrioridadeSelecionada) {
		this.taskTipoPrioridadeSelecionada = taskTipoPrioridadeSelecionada;
	}

	public RequestCustomer getTaskClienteSelecionado() {
		return taskClienteSelecionado;
	}

	public void setTaskClienteSelecionado(RequestCustomer taskClienteSelecionado) {
		this.taskClienteSelecionado = taskClienteSelecionado;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getQtdaHoras() {
		return qtdaHoras;
	}

	public void setQtdaHoras(Date qtdaHoras) {
		this.qtdaHoras = qtdaHoras;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public TypeOfAction getTaskTipoAcaoSelecionada() {
		return taskTipoAcaoSelecionada;
	}

	public void setTaskTipoAcaoSelecionada(TypeOfAction taskTipoAcaoSelecionada) {
		this.taskTipoAcaoSelecionada = taskTipoAcaoSelecionada;
	}

	public User getUserSelecionado() {
		return userSelecionado;
	}

	public void setUserSelecionado(User userSelecionado) {
		this.userSelecionado = userSelecionado;
	}

}
