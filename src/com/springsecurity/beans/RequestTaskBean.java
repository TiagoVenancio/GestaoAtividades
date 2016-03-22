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
import com.springsecurity.entities.TypeOfGroup;
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
	private TypeOfGroup tipoGrupoSelected;

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

	public TypeOfGroup getTipoGrupoSelected() {
		return tipoGrupoSelected;
	}

	public void setTipoGrupoSelected(TypeOfGroup tipoGrupoSelected) {
		this.tipoGrupoSelected = tipoGrupoSelected;
	}

}
