package com.springsecurity.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class ResetValuesDialogBean {

	public void handleClose(CloseEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				event.getComponent().getId() + " closed",
				"So you don't like nature?");
		facesContext.addMessage(null, message);
	}

}
