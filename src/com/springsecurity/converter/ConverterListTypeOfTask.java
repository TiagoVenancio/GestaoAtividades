package com.springsecurity.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.springsecurity.dao.TypeOfTaskDao;
import com.springsecurity.dao.impl.TypeOfTaskDaoImpl;
import com.springsecurity.entities.TypeOfTask;

@FacesConverter(value = "converterListaTipoTarefas")
public class ConverterListTypeOfTask implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.equals("")) {
			TypeOfTaskDao dao = new TypeOfTaskDaoImpl();
			return dao.getById(Long.valueOf(value));
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