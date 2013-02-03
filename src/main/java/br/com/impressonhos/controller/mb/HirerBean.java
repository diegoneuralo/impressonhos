package br.com.impressonhos.controller.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import br.com.impressonhos.entity.Contratante;
import br.com.impressonhos.entity.Endereco;
import br.com.impressonhos.entity.Pessoa;
import br.com.impressonhos.entity.Telefone;
import br.com.impressonhos.entity.TipoLogradouro;
import br.com.impressonhos.entity.Uf;
import br.com.impressonhos.enums.TipoEndereco;
import br.com.impressonhos.enums.TipoPessoa;
import br.com.impressonhos.enums.TipoTelefone;
import br.com.impressonhos.service.ContratanteService;
import br.com.impressonhos.service.PessoaService;
import br.com.impressonhos.service.TipoLogradouroService;
import br.com.impressonhos.service.UfService;
import br.com.impressonhos.util.exception.ObjectAlreadyExistsException;

@Named("hirer")
@ViewScoped
public class HirerBean extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Pessoa	pessoa;
	private Contratante contratante;
	private Endereco endereco;
	private Telefone telefone;
	
	@Inject private UfService ufService;
	@Inject private ContratanteService contratanteService;
	@Inject private TipoLogradouroService tipoLogradouroService;
	@Inject private PessoaService pessoaService;
	@Inject transient Logger LOG;
	
	List<SelectItem> listaUf;
	List<Contratante> listaContratante;
	List<SelectItem> listaTipoLogradouro;
	List<Endereco> listaEnderecos;
	List<Telefone> listaTelefones;

	@PostConstruct
	public void construct(){
		System.out.println("HirerBean.construct()");
		listaContratante = contratanteService.findAll();
		
		pessoa = new Pessoa();
		
		contratante = new Contratante();
		contratante.setPessoa(pessoa);
		
		endereco = new Endereco();
		telefone = new Telefone();
		
		listaEnderecos = new ArrayList<Endereco>();
		listaTelefones = new ArrayList<Telefone>();
	}
	
	public void newRecord(){
		System.out.println("HirerBean.newRecord()");

		this.step = 1;
	}
	
	public void editRecord(){
		System.out.println("HirerBean.editRecord()");
		this.step = 1;
	}
	
	public void saveRecord(){
		System.out.println("HirerBean.saveRecord()");

		for(Endereco e : listaEnderecos)
			try {
				pessoa.addEndereco(e);
			} catch (ObjectAlreadyExistsException oaee) {
				growl.addInfoMessage(oaee.getMessage());
			}
		
		for(Telefone t : listaTelefones)
			try {
				pessoa.addTelefone(t);
			} catch (ObjectAlreadyExistsException oaee) {
				growl.addInfoMessage(oaee.getMessage());
			}
		
		System.out.println(pessoa);
		
		pessoa = pessoaService.save(pessoa);
		contratante = contratanteService.save(contratante);

		if(contratante != null){
			if(!listaContratante.contains(contratante))
				listaContratante.add(contratante);
			
			this.step = 0;
			
			growl.addInfoMessage("gravacao.sucesso");
		} else {
			growl.addErrorMessage("gravacao.erro");
		}
	}
	
	public void cancel(){
		System.out.println("HirerBean.cancel()");
		this.step = 0;
	}
	
	public void deleteRecord(){
		System.out.println("HirerBean.deleteRecord()");
		
		if(contratanteService.remove(contratante)){
			listaContratante.remove(contratante);
			
			growl.addInfoMessage("remocao.sucesso");
		} else {
			growl.addErrorMessage("remocao.erro");
		}
		
		this.step = 0;
	}

	public void seeContracts(){
		System.out.println("HirerBean.seeContracts()");
	}
	
	public void addEndereco(){
		System.out.println("MainBean.addEndereco()");
		listaEnderecos.add(endereco);
	}
	
	public void removeEndereco(){
		System.out.println("MainBean.removeEndereco()");
		listaEnderecos.remove(endereco);
	}
	
	public void addTelefone(){
		System.out.println("MainBean.addTelefone()");
		listaTelefones.add(telefone);
	}
	
	public void removeTelefone(){
		System.out.println("MainBean.removeTelefone()");
		listaTelefones.remove(telefone);
	}
	
	/* -- Getters and Setters */
	
	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public List<Contratante> getListaContratante() {
		return listaContratante;
	}

	public void setListaContratante(List<Contratante> listaContratante) {
		this.listaContratante = listaContratante;
	}
	
	public TipoPessoa[] getTiposDePessoa() {
		System.out.println("HirerBean.getTiposDePessoa() -> "+this.contratante.getPessoa().getTipo());
		return TipoPessoa.values();
	}
	
	public String getLabel() {
		return contratante.getId().equals(new Long(0)) || contratante.getId() == null ? "novo.registro" : "editar.registro";
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

	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}
}

