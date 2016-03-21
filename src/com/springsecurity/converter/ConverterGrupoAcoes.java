package com.springsecurity.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.springsecurity.entities.TypeOfAction;
import com.springsecurity.service.TypeOfActionService;

@FacesConverter(value = "converterGrupoAcoes")
public class ConverterGrupoAcoes implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				TypeOfActionService service = (TypeOfActionService) fc
						.getExternalContext().getApplicationMap()
						.get("typeOfActionBean");
				return service.getAllTipoDeAcoes().get(Integer.parseInt(value));
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
			return String.valueOf(((TypeOfAction) object).getId());
		} else {
			return null;
		}
	}
}