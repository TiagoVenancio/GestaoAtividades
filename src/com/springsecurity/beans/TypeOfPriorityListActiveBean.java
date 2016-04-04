package com.springsecurity.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.TypeOfPriority;
import com.springsecurity.service.TypeOfPriorityService;

@Controller
@Scope("request")
public class TypeOfPriorityListActiveBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TypeOfPriorityService service;
	private List<TypeOfPriority> listaPrioridadeAtivas;

	public TypeOfPriorityListActiveBean() {
	}

	@PostConstruct
	public void init() {
		listaPrioridadeAtivas = service.listarPrioridadesAtivas();

	}

	public List<TypeOfPriority> getListaPrioridadeAtivas() {
		return listaPrioridadeAtivas;
	}

	public void setListaPrioridadeAtivas(
			List<TypeOfPriority> listaPrioridadeAtivas) {
		this.listaPrioridadeAtivas = listaPrioridadeAtivas;
	}

}