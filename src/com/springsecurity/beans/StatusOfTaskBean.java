package com.springsecurity.beans;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import com.springsecurity.dao.impl.StatusOfTaskDAOImpl;
import com.springsecurity.entities.StatusOfTask;
import com.springsecurity.enums.StatusFinalAction;
import com.springsecurity.enums.StatusObjectEnum;

@ManagedBean(name = "statusOfTaskBean")
@ViewScoped
public class StatusOfTaskBean {

	// Instanciar objeto e seu DAOImp;

	StatusOfTask statusOfTask = new StatusOfTask();
	StatusOfTaskDAOImpl daoImpl = new StatusOfTaskDAOImpl();

	// Criar atributos visiveis para o JSF;

	private StatusObjectEnum statusObjectEnum;
	private String description;
	private StatusFinalAction statusFinalAction;

	// Criar construtor vazio;

	public StatusOfTaskBean() {

	}

	// Implementação do metodo save;

	public void salvar(ActionEvent actionEvent) {

		statusOfTask.setCreateDate(Calendar.getInstance());
		statusOfTask.setLastUpdate(Calendar.getInstance());
		statusOfTask.setDescription(description);
		statusOfTask.setStatusFinalAction(statusFinalAction);
		statusOfTask.setStatusObjectEnum(statusObjectEnum);

		daoImpl.save(statusOfTask);

	}

	// getters and setters

	public StatusOfTask getStatusOfTask() {
		return statusOfTask;
	}

	public void setStatusOfTask(StatusOfTask statusOfTask) {
		this.statusOfTask = statusOfTask;
	}

	public StatusObjectEnum getStatusObjectEnum() {
		return statusObjectEnum;
	}

	public void setStatusObjectEnum(StatusObjectEnum statusObjectEnum) {
		this.statusObjectEnum = statusObjectEnum;
	}

	public StatusFinalAction getStatusFinalAction() {
		return statusFinalAction;
	}

	public void setStatusFinalAction(StatusFinalAction statusFinalAction) {
		this.statusFinalAction = statusFinalAction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
