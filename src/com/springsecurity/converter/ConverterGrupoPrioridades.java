package com.springsecurity.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.springsecurity.entities.TypeOfGroup;
import com.springsecurity.service.TypeOfPriorityService;

@FacesConverter(value = "converterGrupoPrioridades")
public class ConverterGrupoPrioridades implements Converter {

	private TypeOfPriorityService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.equals("")) {
			return service.getByIdTypeOfPriority(Long.valueOf(value));
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