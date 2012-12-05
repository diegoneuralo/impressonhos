package br.com.impressonhos.util;

import java.util.Locale;

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
	
	static public Locale getLocale() throws Exception {
		Locale l = (Locale)sessionGetAttribute("SYS_LOCALE");
		if ( l == null ) {
			FacesContext facesInstance = FacesContext.getCurrentInstance();
			if( facesInstance != null){
				l = FacesContext.getCurrentInstance().getViewRoot().getLocale();
			}
			if ( l == null ) l = new Locale("pt","BR");
			if ( l.toString().startsWith("en") ) setLocale( new Locale("en","US") );
			else if ( l.toString().startsWith("es") ) setLocale( new Locale("es","ES") );
			else setLocale(l);
		}
		else FacesContext.getCurrentInstance().getViewRoot().setLocale(l);
  		return l;
	}
	
	static public void setLocale( Locale l ) throws Exception {
		FacesContext facesInstance = FacesContext.getCurrentInstance();
		if( facesInstance != null){
			sessionSetAttribute( "SYS_LOCALE", l );
			FacesContext.getCurrentInstance().getViewRoot().setLocale(l);
		}
	}
}
