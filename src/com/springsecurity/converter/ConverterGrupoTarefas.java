package com.springsecurity.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.springsecurity.entities.TypeOfTask;
import com.springsecurity.service.TypeOfTaskService;

@FacesConverter(value = "converterTipoTarefa")
public class ConverterGrupoTarefas implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				TypeOfTaskService service = (TypeOfTaskService) fc
						.getExternalContext().getApplicationMap()
						.get("typeOfTaskBean");
				return service.getAll().get(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Conversion Error",
						"Not a valid theme."));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((TypeOfTask) object).getId());
		} else {
			return null;
		}
	}
}