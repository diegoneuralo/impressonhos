package br.com.impressonhos.controller.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.impressonhos.util.Services;

@Named("navigation")
@RequestScoped
/**
 * ManagedBean responsável pelo controle da navegação.
 * Utiliza variáveis de sessão para controlar a página em que o usuário se encontra.
 * @author riccardof
 *
 */
public class NavigationBean implements Serializable{		
	private static final long serialVersionUID = 1L;
	
	private String selectedIncludePath;
	
	public String getSelectedIncludePath() {
		String path = (String) Services.sessionGetAttribute("SYS_TELA");
		
    	if(path != null)
        	setSelectedIncludePath(path);
	    	else
	        	{
		    		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		    		try {
		    			externalContext.redirect(externalContext.getRequestContextPath() + "/login.jsf");
		    		} catch (IOException e) {
		    			//logger.error(e.getCause().getMessage());
		    		}
	        	}
    	
		return selectedIncludePath;
	}

	public void setSelectedIncludePath(String selectedIncludePath) {
		Services.sessionSetAttribute("SYS_TELA", selectedIncludePath );
		this.selectedIncludePath = selectedIncludePath;
	}
}
