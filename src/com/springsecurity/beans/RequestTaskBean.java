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

	private Long idTarefa;

	@Autowired
	private RequestTaskService tarefaService;
	private List<RequestTask> listaTarefas;
	private RequestTask tarefaSelecionada;

	private StatusObjectEnum statusObjectEnum;

	public RequestTaskBean() {
		tarefaSelecionada = new RequestTask();
	}

	@PostConstruct
	public void init() {
		listaTarefas = tarefaService.getAllRequestTasks();
	}

	public String incluirFila() {
		try {
			tarefaSelecionada.setCreateDate(new Date(System.currentTimeMillis()));
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

	public String editar() {
		try {

			RequestTask editarTarefa = new RequestTask();

			editarTarefa.setId(tarefaSelecionada.getId());

			editarTarefa.setAmountHours(tarefaSelecionada.getAmountHours());
			editarTarefa.setCloseDate(tarefaSelecionada.getCloseDate());
			editarTarefa.setConclusionDate(tarefaSelecionada.getConclusionDate());
			editarTarefa.setCreateDate(tarefaSelecionada.getCreateDate());
			editarTarefa.setDescription(tarefaSelecionada.getDescription());
			editarTarefa.setRequestCustomer(tarefaSelecionada.getRequestCustomer());
			editarTarefa.setResume(tarefaSelecionada.getResume());
			editarTarefa.setStartDate(tarefaSelecionada.getStartDate());

			editarTarefa.setStatusObjectEnum(StatusObjectEnum.Ativo);
			editarTarefa.setStatusTaskEnum(StatusTaskEnum.A_FAZER);

			editarTarefa.setTypeOfAction(tarefaSelecionada.getTypeOfAction());
			editarTarefa.setTypeOfActivity(tarefaSelecionada.getTypeOfActivity());
			editarTarefa.setTypeOfPriority(tarefaSelecionada.getTypeOfPriority());
			editarTarefa.setUserOwnerTask(tarefaSelecionada.getUserOwnerTask());

			tarefaService.editar(editarTarefa);

			tarefaService.editar(getTarefaSelecionada());

			listaTarefas = tarefaService.getAllRequestTasks();

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
							"Item alterado com sucesso!"));
			return null;

		} catch (DataAccessException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha!",
							"Item não alterado!"));
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

	public Long getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Long idTarefa) {
		this.idTarefa = idTarefa;
	}

	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

}