package br.com.impressonhos.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class Services {
	
	static public Object sessionGetAttribute(String attributeName){
		Object value = null;
		FacesContext facesInstance = FacesContext.getCurrentInstance();
		if ( facesInstance != null ) {
			HttpSession currentSession = ((HttpSession)facesInstance.getExternalContext().getSession(false));
			if ( currentSession != null ) value = currentSession.getAttribute(attributeName);
		}
		return value;
	}
	
	static public void sessionSetAttribute(String attributeName,Object attributeValue){
		FacesContext facesInstance = FacesContext.getCurrentInstance();
		if ( facesInstance != null ){
			HttpSession currentSession = ((HttpSession)facesInstance.getExternalContext().getSession(false));
			if ( currentSession != null ) currentSession.setAttribute(attributeName,attributeValue);
		}
	}

	static public void sessionRemoveAttribute(String attributeName){
		FacesContext facesInstance = FacesContext.getCurrentInstance();
		if ( facesInstance != null ){
			HttpSession currentSession = ((HttpSession)facesInstance.getExternalContext().getSession(false));
			if ( currentSession != null ) currentSession.removeAttribute(attributeName);
		}
	}
}
