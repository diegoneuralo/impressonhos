package br.com.impressonhos.controller.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.seam.security.Authenticator;
import org.jboss.seam.security.BaseAuthenticator;
import org.jboss.seam.security.CredentialsImpl;
import org.jboss.seam.security.Identity;
import org.jboss.solder.logging.Logger;
import org.picketlink.idm.impl.api.PasswordCredential;
import org.picketlink.idm.impl.api.model.SimpleUser;

import br.com.impressonhos.entity.User;
import br.com.impressonhos.enums.Const;
import br.com.impressonhos.service.UserService;
import br.com.impressonhos.util.Services;

@Named("authentication")
@SessionScoped
public class AuthenticationMB extends BaseAuthenticator implements Authenticator, Serializable 
{	
	@Inject private UserService userService;
	@Inject private CredentialsImpl credentials;
	@Inject private Identity identity;
	@Inject private Logger logger;
	@Inject private Event<User> loginEventSrc;

	@Override
	public void authenticate()
	{
		logger.info("Tentativa de login: " + credentials.getUsername());
		User user = userService.getUserByCredential(credentials.getUsername(), credentials.getPassword());
		if (user != null && credentials.getCredential() instanceof PasswordCredential && 
			user.getPassword().equals(((PasswordCredential) credentials.getCredential()).getValue())) 
		{
			loginEventSrc.fire(user);
			super.setStatus(AuthenticationStatus.SUCCESS);
			identity.addRole(credentials.getUsername(), "USERS", "GROUP");
			super.setUser(new SimpleUser(user.getLogin()));
			
			Services.sessionSetAttribute("SYS_TELA", Const.PRINCIPAL);
			redirectToViewId(Const.HOME);
			return;
		}
		setStatus(AuthenticationStatus.FAILURE);
		addLoginErrorMessage("User not found");
		redirectToLoginIfNotLoggedIn();
	}

//	public void logout() {
//		String userKey = identity.getUser().getKey();
//		identity.setAuthenticatorClass(IdmAuthenticator.class);
//		identity.logout();
//		logger.info("User logged out " + userKey);
//	}

	@Override
	public AuthenticationStatus getStatus() 
	{
		return super.getStatus();
	}

	public boolean isLoggedIn() 
	{
		return getStatus().equals(AuthenticationStatus.SUCCESS);
	}

	public void redirectToLoginIfNotLoggedIn() 
	{
		if (!isLoggedIn()) 
		{
			credentials.setUsername("");
			addLoginErrorMessage("User not found!");
			redirectToViewId("/login.jsf");
		}
	}

	private void redirectToViewId(String viewId) 
	{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect(externalContext.getRequestContextPath() + viewId);
		} catch (IOException e) {
			logger.error(e.getCause().getMessage());
		}
	}
	
	public void addLoginErrorMessage(String infoMessage) 
	{
		addMessage(null, infoMessage, FacesMessage.SEVERITY_ERROR);
	}		
	
	private void addMessage(String componentId, String errorMessage, Severity severity)
	{
		FacesMessage message =  new FacesMessage(errorMessage);
		message.setSeverity(severity);
		FacesContext.getCurrentInstance().addMessage(componentId, message);	
	}

	private static final long serialVersionUID = 8944449513389432047L;

}
