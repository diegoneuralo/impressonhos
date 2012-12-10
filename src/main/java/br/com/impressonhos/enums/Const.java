package br.com.impressonhos.enums;

import javax.inject.Named;

@Named("const")
public final class Const {
	
	/**
	 * representa o nome do schema do banco de dados
	 */
	public static final String SCHEMA = "impressonhos";		
	
	/**
	 * path defaul das paginas
	 */
	public static final String PAGES_PATH = "/WEB-INF/includes/pages/";
	
	/**
	 * página de login do sistema
	 */
	public static final String LOGIN = "login.jsf";
	
	/**
	 * página principal do container ajax
	 */
	public static final String HOME = "/home.jsf";
	
	/**
	 * página principal do sistema 
	 */
	public static final String PRINCIPAL = "/WEB-INF/includes/main/main.xhtml";
	
	/**
	 * Página de cadastro de modelos de convites
	 */
	public static final String MODELOS_CONVITES = PAGES_PATH + "modeloConvite/modelo-convite.xhtml";

	public String getPrincipal(){
		return PRINCIPAL;
	}
	
	public String getModelosConvites() {
		return MODELOS_CONVITES;
	}
	
	/**
	 * página de criação dos projetos 
	 *//*
	public static final String ADD_PROJECT = "/pages/add_project.jsf?faces-redirect=true";
	
	*//**
	 * página de vizualização dos projetos 
	 *//*
	public static final String LIST_PROJECT = "/pages/list_project.jsf?faces-redirect=true";
	
	*//**
	 * página de criação de sprints 
	 *//*	
	public static final String ADD_SPRINT = "/pages/project/add_sprint.jsf?faces-redirect=true";
	
	*//**
	 * página de vizualização dos sprints 
	 *//*	
	public static final String LIST_SPRINT = "/pages/project/list_sprint.jsf?faces-redirect=true";
*/
	
}
