package br.com.impressonhos.controller.mb;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.solder.exception.control.ExceptionToCatch;
import org.primefaces.context.RequestContext;

import br.com.impressonhos.util.MessageBundleLoader;

/**
 * Controle do Growl
 */
@Named("growl")
@RequestScoped
public class GrowlBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject private Event<ExceptionToCatch> exception;
	@Inject private MessageBundleLoader mbl;
	
	/** Se o Growl deve permanecer "grudado" na tela, aguardando ate interacao do usuario 
	 */
	private Boolean sticky = false;
	
	/**
	 * Tempo em que o Growl permanecera exibido antes do mesmo se fechar na tela do usuario
	 */
	private Integer lifeTime = 5000;
	
	/**
	 * Controle da exibicao do detalhe da mensagem
	 */
	private Boolean showDetail = false;
	
	public void addInfoMessage(String infoMessage){
		addInfoMessage(null, infoMessage, true);
	}
	
	public void addInfoMessage(String componentId, String infoMessage, boolean update){
		addFacesMessage(componentId, FacesMessage.SEVERITY_INFO, infoMessage, null);
		if(update) this.update();
	}
	
	public void addWarnMessage(String warnMessage){
		addWarnMessage(null, warnMessage, true);
	}
	
	public void addWarnMessage(String componentId, String warnMessage, boolean update){
		addFacesMessage(componentId, FacesMessage.SEVERITY_WARN, warnMessage, null);
		if(update) this.update();
	}

	public void addErrorMessage(String errorMessage){
		addErrorMessage(null, errorMessage, true);
	}
	
	public void addErrorMessage(String componentId, String errorMessage, boolean update){
		addFacesMessage(componentId, FacesMessage.SEVERITY_WARN, errorMessage, null);
		if(update) this.update();
	}

	/**
	 * Adiciona uma mensagem ao contexto para exibicao do growl, ou qquer outro elemento que utilize mensagens
	 * @param componentId The component identifier with which this message is associated (if any)
	 * @param sev (FacesMessage.Severity) 
	 * 	<ul>
	 * 		<lh><b>Have to be one of the options below:</b></lh>
	 * 		<li>FacesMessage.SEVERITY_INFO</li>
	 * 		<li>FacesMessage.SEVERITY_WARN</li>
	 * 		<li>FacesMessage.SEVERITY_ERROR</li>
	 * 		<li>FacesMessage.SEVERITY_FATAL</li>
	 * 	</ul>
	 * @param summary e o titulo do growl
	 * @param detail conteudo da mensagem a ser exibida
	 */
	public void addFacesMessage(String componentId, FacesMessage.Severity sev, String summary, String detail){
		try {
			if(detail != null){
				this.showDetail = true;
			}
			FacesMessage message = new FacesMessage(sev, mbl.getMessage(summary), mbl.getMessage(detail));
			FacesContext.getCurrentInstance().addMessage(componentId, message);
		
		} catch (Exception e) {
			System.out.println("GrowBean.addFacesMessage()");
			exception.fire(new ExceptionToCatch(e));
		}
	}
	
	/**
	 * Atualiza o grow padrão (localizado no template).
	 */
	public void update(){
		System.out.println("GrowlBean.update()");
		update("growl");
	}
	
	/**
	 * Atualiza o elemento cujo id foi especificado
	 * @param elemId
	 */
	public void update(String growId){
		try {
			RequestContext.getCurrentInstance().update(growId);
		} catch (Exception e) {
			exception.fire(new ExceptionToCatch(e));
		}
	}
	
	// -- Getters and Setter

	public void setSticky(Boolean sticky) {
		this.sticky = sticky;
	}
	
	public Boolean getSticky() {
		return this.sticky;
	}

	public void setLifeTime(Integer lifeTime) {
		this.lifeTime = lifeTime;
	}
	
	public Integer getLifeTime() {
		return this.lifeTime;
	}

	public void setShowDetail(Boolean showDetail) {
		this.showDetail = showDetail;
	}
	
	public Boolean getShowDetail() {
		return this.showDetail;
	}
}
