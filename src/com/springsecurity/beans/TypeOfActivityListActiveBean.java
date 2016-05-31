package com.springsecurity.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.service.TypeOfActivityService;

@Controller
@Scope("request")
public class TypeOfActivityListActiveBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TypeOfActivityService service;
	private List<TypeOfActivity> listaAtividadesAtivas;

	public TypeOfActivityListActiveBean() {
	}

	@PostConstruct
	public void init() {
		listaAtividadesAtivas = service.listarAtividadesAtivas();

	}

	public List<TypeOfActivity> getListaAtividadesAtivas() {
		return listaAtividadesAtivas;
	}

	public void setListaAtividadesAtivas(List<TypeOfActivity> listaAtividadesAtivas) {
		this.listaAtividadesAtivas = listaAtividadesAtivas;
	}

}