package com.springsecurity.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.springsecurity.entities.TypeOfTask;
import com.springsecurity.service.TypeOfTaskService;

@Controller
@Scope("request")
public class TypeOfTaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TypeOfTaskService typeOfTaskService;
	private List<TypeOfTask> listaTiposTarefas;

	public TypeOfTaskBean() {

	}

	@PostConstruct
	public void init() {
		listaTiposTarefas = typeOfTaskService.getAllTipoDeTarefas();

	}

	public List<TypeOfTask> getListaTiposTarefas() {
		return listaTiposTarefas;
	}

	public void setListaTiposTarefas(List<TypeOfTask> listaTiposTarefas) {
		this.listaTiposTarefas = listaTiposTarefas;
	}

}
