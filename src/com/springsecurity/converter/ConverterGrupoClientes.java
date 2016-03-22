package com.springsecurity.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import com.springsecurity.entities.RequestCustomer;
import com.springsecurity.service.RequestCustomerService;

@FacesConverter(value = "converterGrupoClientes")
public class ConverterGrupoClientes implements Converter {

	@Autowired
	private RequestCustomerService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.equals("")) {
			return service.getByIdRequestCustomer(Long.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof RequestCustomer) {
			RequestCustomer requestCustomer = (RequestCustomer) value;
			return String.valueOf(requestCustomer.getId());
		}
		return "";
	}
}