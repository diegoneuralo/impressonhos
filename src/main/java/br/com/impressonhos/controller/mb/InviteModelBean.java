package br.com.impressonhos.controller.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.impressonhos.entity.ModeloConvite;
import br.com.impressonhos.service.ModeloConviteService;

@Named("inviteModel")
@ViewScoped
public class InviteModelBean extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject private ModeloConvite modeloConvite;
	@Inject private ModeloConviteService modeloConviteService;
	
	List<ModeloConvite> listaModeloConvite;

	@PostConstruct
	public void construct(){
		System.out.println("InviteModelBean.construct()");
		listaModeloConvite = modeloConviteService.findAll();
	}
	
	public void newRecord(){
		System.out.println("InviteModelBean.newRecord()");
		modeloConvite = new ModeloConvite();
		this.step = 1;
	}
	
	public void editRecord(){
		System.out.println("InviteModelBean.editRecord()");
		this.step = 1;
	}
	
	public void saveRecord(){
		System.out.println("InviteModelBean.saveRecord()");
		
		modeloConvite = modeloConviteService.save(modeloConvite);
		listaModeloConvite.add(modeloConvite); 
		System.out.println(listaModeloConvite);
		
		this.step = 0;
		
		growl.addInfoMessage("gravacao.sucesso");
	}
	
	public void cancel(){
		System.out.println("InviteModelBean.cancel()");
		this.step = 0;
	}
	
	public void deleteRecord(){
		System.out.println("InviteModelBean.deleteRecord()");
		System.out.println(modeloConvite);
		
		modeloConviteService.remove(modeloConvite);
		listaModeloConvite.remove(modeloConvite);
		
		this.step = 0;
		
		growl.addInfoMessage("remocao.sucesso");
	}

	/* -- Getters and Setters */
	
	public ModeloConvite getModeloConvite() {
		return modeloConvite;
	}

	public void setModeloConvite(ModeloConvite modeloConvite) {
		this.modeloConvite = modeloConvite;
	}

	public List<ModeloConvite> getListaModeloConvite() {
		return listaModeloConvite;
	}

	public void setListaModeloConvite(List<ModeloConvite> listaModeloConvite) {
		this.listaModeloConvite = listaModeloConvite;
	}

	public String getLabel() {
		return modeloConvite.getId().equals(new Long(0)) ? "novo.modelo.convite" : "modelo.convite.editar";
	}
}
