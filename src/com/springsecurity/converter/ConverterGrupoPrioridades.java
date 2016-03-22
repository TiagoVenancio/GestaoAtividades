package com.springsecurity.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import com.springsecurity.entities.TypeOfPriority;
import com.springsecurity.service.TypeOfPriorityService;

@FacesConverter(value = "converterGrupoPrioridades")
public class ConverterGrupoPrioridades implements Converter {

	@Autowired
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
		if (value instanceof TypeOfPriority) {
			TypeOfPriority typeOfPriority = (TypeOfPriority) value;
			return String.valueOf(typeOfPriority.getId());
		}
		return "";
	}
}