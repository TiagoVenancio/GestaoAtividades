package com.springsecurity.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.User;
import com.springsecurity.service.UserService;

@Controller
@Scope(value = "session")
public class UserOwnerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	private List<User> listaUsuarios;

	public UserOwnerBean() {

	}

	@PostConstruct
	public void init() {

		listaUsuarios = userService.getAll();

	}

	public List<User> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<User> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
