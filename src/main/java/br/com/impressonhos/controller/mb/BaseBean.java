package br.com.impressonhos.controller.mb;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import br.com.impressonhos.util.MessageBundleLoader;

public class BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject protected MessageBundleLoader mbl;
	@Inject @ManagedProperty(value="#{growl}") protected GrowlBean growl;
		
	/**
	 * Controle dos passos - para os .xhtml que dependem disso.
	 */
	protected Integer step = 0; 
	
	/**
	 * Base para atualizacao via ajax do Primefaces 
	 * Serve de suporte aos metodos da biblioteca:
	 * <ul>
	 * 	<li>update(s)</li>
	 * 	<li>execute()</li>
	 * </ul>
	 * @throws Exception 
	 */
	public static RequestContext ajaxHelper() throws Exception{
		RequestContext rc = RequestContext.getCurrentInstance();
		if(rc != null){
			return rc;
		} else {
			throw new Exception("Primefaces Ajax Handler - Failure");
		}
	}

	/**
	 * Atualiza o elemento cujo id foi especificado
	 * @param elemId
	 */
	public void update(String elemId){
		try {
			ajaxHelper().update(elemId);
		} catch (Exception e) {
			System.out.println("Container.update() - ERRO: "+e.getMessage());
		}
	}
	
	/**
	 * Atualiza os elemento cujos ids foram especificados
	 * @param elemId
	 */
	public void update(Collection<String> toUpdate){
		try {
			ajaxHelper().update(toUpdate);
		} catch (Exception e) {
			System.out.println("Container.update() - ERRO:"+e.getMessage());
		}
	}
	
	/**
	 * Executa uma ou mais instrucoes javascript no cliente.
	 * @param script
	 */
	public void execute(String script){
		try {
			ajaxHelper().execute(script);
		} catch (Exception e) {
			System.out.println("Container.primeExecute() - ERRO: "+e.getMessage());
		}
	}
	
	// -- Getters and Setter
	
	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}
}
