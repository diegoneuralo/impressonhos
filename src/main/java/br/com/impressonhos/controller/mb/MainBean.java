package br.com.impressonhos.controller.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.impressonhos.entity.Pessoa;
import br.com.impressonhos.enums.TipoPessoa;

@Named("main")
@ViewScoped
public class MainBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;

	@PostConstruct
	public void construct(){
		System.out.println("MainBean.construct()");
		pessoa = new Pessoa();
	}
	
	public void save(){
		System.out.println("MainBean.save()");
		System.out.println(pessoa.getTipo().name());
	}
	
	public void cancel(){
		System.out.println("MainBean.cancel()");
	}
	
	public void delete(){
		System.out.println("MainBean.delete()");
	}
	
	/* -- Getters and Setters */
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoPessoa[] getTiposDePessoa() {
		return TipoPessoa.values();
	}
}