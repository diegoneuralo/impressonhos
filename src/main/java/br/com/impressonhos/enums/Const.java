package br.com.impressonhos.enums;

import javax.inject.Named;

@Named("const")
public final class Const {
	
	/**
	 * Representa o nome do schema do banco de dados
	 */
	public static final String SCHEMA = "impressonhos";		
	
	/**
	 * Path default das páginas
	 */
	public static final String PAGES_PATH = "/WEB-INF/includes/pages/";
	
	/**
	 * Página de login do sistema
	 */
	public static final String LOGIN = "login.jsf";
	
	/**
	 * Página principal do container ajax
	 */
	public static final String HOME = "/home.jsf";
	
	public static final String PRINCIPAL = "/WEB-INF/includes/main/main.xhtml";
	
	public static final String MODELOS_CONVITES = PAGES_PATH + "modeloConvite/modelo-convite.xhtml";
	
	public static final String CONTRATANTES = PAGES_PATH + "contratante/contratante.xhtml";
	
	public static final String TIPOS_PAPEL = PAGES_PATH + "tipoPapel/tipo-papel.xhtml";

	/**
	 * Página principal do sistema 
	 */
	public String getPrincipal(){
		return PRINCIPAL;
	}
	
	/**
	 * Página de cadastro de modelos de convites
	 */
	public String getModelosConvites() {
		return MODELOS_CONVITES;
	}
	
	/**
	 * Página de cadastro de contratantes
	 */
	public String getContratantes() {
		return CONTRATANTES;
	}

	/**
	 * Página de cadastro de tipos de papel
	 */
	public String getTiposPapel() {
		return TIPOS_PAPEL;
	}
}
