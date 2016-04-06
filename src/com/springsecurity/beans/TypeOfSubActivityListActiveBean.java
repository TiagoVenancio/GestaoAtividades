package com.springsecurity.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.TypeOfSubActivity;
import com.springsecurity.service.TypeOfSubActivityService;

@Controller
@Scope("request")
public class TypeOfSubActivityListActiveBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TypeOfSubActivityService service;
	private List<TypeOfSubActivity> listaPrioridadeAtivas;

	public TypeOfSubActivityListActiveBean() {
	}

	@PostConstruct
	public void init() {
		setListaPrioridadeAtivas(service.listarAtividadesAtivas());

	}

	public List<TypeOfSubActivity> getListaPrioridadeAtivas() {
		return listaPrioridadeAtivas;
	}

	public void setListaPrioridadeAtivas(
			List<TypeOfSubActivity> listaPrioridadeAtivas) {
		this.listaPrioridadeAtivas = listaPrioridadeAtivas;
	}

}