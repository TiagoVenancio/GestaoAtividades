package com.springsecurity.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.springsecurity.entities.TypeOfGroup;
import com.springsecurity.service.TypeOfActivityService;

@FacesConverter(value = "converterGrupoAtividade")
public class ConverterGrupoAtividades implements Converter {

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
		if (value instanceof TypeOfGroup) {
			TypeOfGroup typeOfGroup = (TypeOfGroup) value;
			return String.valueOf(typeOfGroup.getId());
		}
		return "";
	}
}