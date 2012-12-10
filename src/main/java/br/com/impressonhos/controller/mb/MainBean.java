package br.com.impressonhos.controller.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.impressonhos.entity.Endereco;
import br.com.impressonhos.entity.Pessoa;
import br.com.impressonhos.entity.Telefone;
import br.com.impressonhos.entity.TipoLogradouro;
import br.com.impressonhos.entity.Uf;
import br.com.impressonhos.enums.TipoEndereco;
import br.com.impressonhos.enums.TipoPessoa;
import br.com.impressonhos.enums.TipoTelefone;
import br.com.impressonhos.service.TipoLogradouroService;
import br.com.impressonhos.service.UfService;

@Named("main")
@ViewScoped
public class MainBean extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject private Pessoa pessoa;
	@Inject private Endereco endereco;
	@Inject private Telefone telefone;
	@Inject private UfService ufService;
	@Inject private TipoLogradouroService tipoLogradouroService;

	List<SelectItem> listaUf;
	List<SelectItem> listaTipoLogradouro;

	@PostConstruct
	public void construct(){
		System.out.println("MainBean.construct()");
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
	
	public void addEndereco(){
		System.out.println("MainBean.addEndereco()");
	}
	
	public void removeEndereco(){
		System.out.println("MainBean.removeEndereco()");
	}
	
	public void addTelefone(){
		System.out.println("MainBean.addTelefone()");
	}
	
	public void removeTelefone(){
		System.out.println("MainBean.removeTelefone()");
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public TipoEndereco[] getTiposDeEndereco() {
		return TipoEndereco.values();
	}
	
	public List<SelectItem> getListaUf() {
		if(listaUf == null){
			listaUf = new ArrayList<SelectItem>();
			listaUf.add(new SelectItem(null, mbl.getMessage("selecione.um.valor")));
			for(Uf uf: ufService.findAll())
				listaUf.add(new SelectItem(uf, uf.getEstado()));
		}
		return listaUf;
	}
	
	public List<SelectItem> getListaTipoLogradouro() {
		if(listaTipoLogradouro == null){
			listaTipoLogradouro = new ArrayList<SelectItem>();
			listaTipoLogradouro.add(new SelectItem(null, mbl.getMessage("selecione.um.valor")));
			for(TipoLogradouro tl: tipoLogradouroService.findAll())
				listaTipoLogradouro.add(new SelectItem(tl, tl.getTipoLogradouro()));
		}
		return listaTipoLogradouro;
	}
	
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public TipoTelefone[] getTiposDeTelefone() {
		return TipoTelefone.values();
	}
}
