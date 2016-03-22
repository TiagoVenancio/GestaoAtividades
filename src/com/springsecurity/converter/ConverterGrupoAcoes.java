package com.springsecurity.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import com.springsecurity.entities.TypeOfAction;
import com.springsecurity.service.TypeOfActionService;

@FacesConverter(value = "converterGrupoAcoes")
public class ConverterGrupoAcoes implements Converter {

	@Autowired
	private TypeOfActionService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.equals("")) {
			return service.getByIdTypeOfAction(Long.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof TypeOfAction) {
			TypeOfAction typeOfAction = (TypeOfAction) value;
			return String.valueOf(typeOfAction.getId());
		}
		return "";
	}
}