package com.springsecurity.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.service.TypeOfActivityService;

@FacesConverter(value = "converterGrupoAtividade")
public class ConverterGrupoAtividades implements Converter {

	@Autowired
	private TypeOfActivityService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.equals("")) {
			return service.getByIdTypeOfActivity(Long.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof TypeOfActivity) {
			TypeOfActivity typeOfActivity = (TypeOfActivity) value;
			return String.valueOf(typeOfActivity.getId());
		}
		return "";
	}
}