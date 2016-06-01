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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.RequestTask;
import com.springsecurity.entities.Role;
import com.springsecurity.entities.User;
import com.springsecurity.entities.UserOwnerTask;
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
	private Role role;
	private User user;
	private UserOwnerTask userOwner;

	private StatusTaskEnum enumSelecionado;
	private StatusObjectEnum statusObjectEnum;

	public RequestTaskBean() {
		tarefaSelecionada = new RequestTask();
	}

	@PostConstruct
	public void init() {

		listaTarefas = tarefaService.listarTarefasPendentes();
		// verificaLogin();
		// listaTarefas = tarefaService.listaPorLogin(userOwner);

	}

	public void verificaLogin() {

		Object usuarioLogado = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (usuarioLogado instanceof UserDetails) {
			((UserDetails) usuarioLogado).getAuthorities().toString()
					.equals("ROLE_ADMIN");

			listaTarefas = tarefaService.getAllRequestTasks();

		}

		else {

			listaTarefas = tarefaService.listaPorLogin(userOwner);

		}

	}

	public String incluirFila() {
		try {
			tarefaSelecionada
					.setCreateDate(new Date(System.currentTimeMillis()));
			tarefaSelecionada.setStatusObjectEnum(StatusObjectEnum.Ativo);
			tarefaSelecionada.setStatusTaskEnum(StatusTaskEnum.A_FAZER);

			tarefaService.adicionar(tarefaSelecionada);

			listaTarefas = tarefaService.listarTarefasPendentes();
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

	public String salvar() {
		try {

			RequestTask salvarTarefa = new RequestTask();

			salvarTarefa.setId(tarefaSelecionada.getId());
			salvarTarefa.setAmountHours(tarefaSelecionada.getAmountHours());
			salvarTarefa.setCloseDate(new Date(System.currentTimeMillis()));
			salvarTarefa.setConclusionDate(tarefaSelecionada
					.getConclusionDate());
			salvarTarefa.setCreateDate(tarefaSelecionada.getCreateDate());
			salvarTarefa.setDescription(tarefaSelecionada.getDescription());
			salvarTarefa.setRequestCustomer(tarefaSelecionada
					.getRequestCustomer());
			salvarTarefa.setResume(tarefaSelecionada.getResume());
			salvarTarefa.setStartDate(tarefaSelecionada.getStartDate());

			switch (enumSelecionado) {
			case A_FAZER:
				salvarTarefa.setStatusObjectEnum(StatusObjectEnum.Ativo);
				break;
			case CANCELADA:
				salvarTarefa.setStatusObjectEnum(StatusObjectEnum.Inativo);
				break;
			case CONCLUIDA:
				salvarTarefa.setStatusObjectEnum(StatusObjectEnum.Inativo);
				break;
			case FAZENDO:
				salvarTarefa.setStatusObjectEnum(StatusObjectEnum.Ativo);
				break;
			}

			salvarTarefa.setStatusTaskEnum(enumSelecionado);

			salvarTarefa.setTypeOfAction(tarefaSelecionada.getTypeOfAction());
			salvarTarefa.setTypeOfActivity(tarefaSelecionada
					.getTypeOfActivity());
			salvarTarefa.setTypeOfPriority(tarefaSelecionada
					.getTypeOfPriority());
			salvarTarefa.setUserOwnerTask(tarefaSelecionada.getUserOwnerTask());

			tarefaService.editar(salvarTarefa);

			listaTarefas = tarefaService.listarTarefasPendentes();

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
							"Item Salvo Com Sucesso!"));
			return "tarefasPendentes";

		} catch (DataAccessException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha!",
							"Item Não Salvo!"));
		}
		return null;

	}

	public String editar() {
		try {

			RequestTask editarTarefa = new RequestTask();

			editarTarefa.setId(tarefaSelecionada.getId());

			editarTarefa.setAmountHours(tarefaSelecionada.getAmountHours());
			editarTarefa.setCloseDate(tarefaSelecionada.getCloseDate());
			editarTarefa.setConclusionDate(tarefaSelecionada
					.getConclusionDate());
			editarTarefa.setCreateDate(tarefaSelecionada.getCreateDate());
			editarTarefa.setDescription(tarefaSelecionada.getDescription());
			editarTarefa.setRequestCustomer(tarefaSelecionada
					.getRequestCustomer());
			editarTarefa.setResume(tarefaSelecionada.getResume());
			editarTarefa.setStartDate(tarefaSelecionada.getStartDate());

			editarTarefa.setStatusObjectEnum(StatusObjectEnum.Ativo);
			editarTarefa.setStatusTaskEnum(StatusTaskEnum.A_FAZER);

			editarTarefa.setTypeOfAction(tarefaSelecionada.getTypeOfAction());
			editarTarefa.setTypeOfActivity(tarefaSelecionada
					.getTypeOfActivity());
			editarTarefa.setTypeOfPriority(tarefaSelecionada
					.getTypeOfPriority());
			editarTarefa.setUserOwnerTask(tarefaSelecionada.getUserOwnerTask());

			tarefaService.editar(editarTarefa);

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserOwnerTask getUserOwner() {
		return userOwner;
	}

	public void setUserOwner(UserOwnerTask userOwner) {
		this.userOwner = userOwner;
	}

	public StatusTaskEnum getEnumSelecionado() {
		return enumSelecionado;
	}

	public void setEnumSelecionado(StatusTaskEnum enumSelecionado) {
		this.enumSelecionado = enumSelecionado;
	}

	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

}