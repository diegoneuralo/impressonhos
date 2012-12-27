package br.com.impressonhos.controller.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.impressonhos.entity.Contratante;
import br.com.impressonhos.entity.Pessoa;
import br.com.impressonhos.enums.TipoPessoa;
import br.com.impressonhos.service.ContratanteService;

@Named("hirer")
@ViewScoped
public class HirerBean extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject private Pessoa	pessoa;
	@Inject private Contratante contratante;
	@Inject private ContratanteService contratanteService;
	
	List<Contratante> listaContratante;

	@PostConstruct
	public void construct(){
		System.out.println("HirerBean.construct()");
		contratante.setPessoa(pessoa);
	}
	
	public void newRecord(){
		System.out.println("HirerBean.newRecord()");
		contratante = new Contratante();
		pessoa = new Pessoa();
		contratante.setPessoa(pessoa);
		this.step = 1;
	}
	
	public void editRecord(){
		System.out.println("HirerBean.editRecord()");
		this.step = 1;
	}
	
	public void saveRecord(){
		System.out.println("HirerBean.saveRecord()");
		
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
		return contratante.getId().equals(new Long(0)) ? "novo.contratante" : "contratante.editar";
	}
}
