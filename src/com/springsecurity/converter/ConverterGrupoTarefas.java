package com.springsecurity.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import com.springsecurity.entities.TypeOfTask;
import com.springsecurity.service.TypeOfTaskService;

@FacesConverter(value = "converterTipoTarefa")
public class ConverterGrupoTarefas implements Converter {

	@Autowired
	private TypeOfTaskService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.equals("")) {
			return service.getByIdTypeOfTask(Long.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof TypeOfTask) {
			TypeOfTask typeOfTask = (TypeOfTask) value;
			return String.valueOf(typeOfTask.getId());
		}
		return "";
	}
}