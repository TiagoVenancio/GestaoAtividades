package com.springsecurity.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.springsecurity.entities.TypeOfActivity;
import com.springsecurity.service.TypeOfActivityService;

@FacesConverter(value = "converterGrupoAtividade")
public class ConverterGrupoAtividades implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				TypeOfActivityService service = (TypeOfActivityService) fc
						.getExternalContext().getApplicationMap()
						.get("typeOfActivityBean");
				return service.getAllTipoDeAtividades().get(
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
			return String.valueOf(((TypeOfActivity) object).getId());
		} else {
			return null;
		}
	}
}