package com.springsecurity.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import com.springsecurity.entities.User;
import com.springsecurity.service.UserService;

@FacesConverter(value = "converterGrupoUsuarios")
public class ConverterGrupoUsuarios implements Converter {

	@Autowired
	private UserService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.equals("")) {
			return service.getByIdUser(Long.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof User) {
			User user = (User) value;
			return String.valueOf(user.getId());
		}
		return "";
	}
}