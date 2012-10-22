package br.com.impressonhos.controller.converter;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@RequestScoped
public class ProjectConverter implements Converter {
	
	//@Inject private ProjectService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if ( value == null || value.trim().isEmpty() ) {
			return null;
		}		
		return null;//service.withId(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		/*if ( value == null || value.equals("") || ((Project) value).getId() == null ) { 
			return "";		
		}*/		
		return null;//((Project) value).getId().toString();			
	}
}
