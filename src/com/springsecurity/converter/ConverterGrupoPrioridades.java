package com.springsecurity.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.springsecurity.entities.TypeOfPriority;
import com.springsecurity.service.TypeOfPriorityService;

@FacesConverter(value = "converterGrupoPrioridades")
public class ConverterGrupoPrioridades implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				TypeOfPriorityService service = (TypeOfPriorityService) fc
						.getExternalContext().getApplicationMap()
						.get("typeOfPriorityBean");
				return service.getAllTipoDePrioridades().get(
						Integer.parseInt(value));
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
			return String.valueOf(((TypeOfPriority) object).getId());
		} else {
			return null;
		}
	}
}