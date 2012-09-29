package br.com.impressonhos.controller.converter;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.impressonhos.entity.Task;
import br.com.impressonhos.service.TaskService;

@Named
@RequestScoped
public class TaskConverter implements Converter {
	
	@Inject private TaskService service;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if ( value == null || value.trim().isEmpty() ) {
			return null;
		}
		return service.withId(Integer.parseInt(value));					
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if ( value == null || value.equals("") || ((Task) value).getId() == null ) {
			return "";
		}
		return ((Task) value).getId().toString();
	}

}
