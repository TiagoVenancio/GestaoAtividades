package com.springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springsecurity.dao.UserDAO;
import com.springsecurity.entities.User;
import com.springsecurity.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserDAO dao;

	public User login(String username) throws IllegalArgumentException {
		if (isEmptyOrNull(username)) {
			throw new IllegalArgumentException("Atenção, Usuário vazios!");
		}
		User u = dao.login(username);

		if (u == null) {
			throw new IllegalArgumentException(
					"Erro: Usuário não cadastrado ou inativo!");
		}
		return u;
	}

	private boolean isEmptyOrNull(String s) {
		return s == null || s.equals("");
	}

}
