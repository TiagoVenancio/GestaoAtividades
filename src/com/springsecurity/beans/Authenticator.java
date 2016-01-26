package com.springsecurity.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.springsecurity.entities.User;
import com.springsecurity.service.LoginService;

@Controller
@Scope("request")
public class Authenticator implements AuthenticationProvider {
	@Autowired
	private LoginService service;

	@Autowired
	private UserSession session;

	private String username;

	private String userLogadoWindows = System.getProperty("user.name");

	public String login() {
		try {
			User user = service.login(username);
			loginSpringSecurity(user);
			session.setUser(user);
			return "successfulPage";
		} catch (IllegalArgumentException ex) {
			message(ex.getMessage());
		}
		return "";
	}

	private void loginSpringSecurity(User user) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				user.getUsername(), null, user.getRoles());
		token.setDetails(user);

		SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.getContext().setAuthentication(token);
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		session.setUser(null);
		return "index";
	}

	private void message(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(message));
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Authentication authenticate(Authentication arg0)
			throws AuthenticationException {
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	public String getUserLogadoWindows() {
		return userLogadoWindows;
	}

	public void setUserLogadoWindows(String userLogadoWindows) {
		this.userLogadoWindows = userLogadoWindows;
	}

}