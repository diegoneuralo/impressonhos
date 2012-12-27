package br.com.impressonhos.controller.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.impressonhos.entity.TipoPapel;
import br.com.impressonhos.service.TipoPapelService;

@Named("invitePaper")
@ViewScoped
public class InvitePaperTypeBean extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject private TipoPapel tipoPapel;
	@Inject private TipoPapelService tipoPapelService;
	
	List<TipoPapel> listaTipoPapel;

	@PostConstruct
	public void construct(){
		System.out.println("InvitePaperTypeBean.construct()");
		listaTipoPapel = tipoPapelService.findAll();
	}
	
	public void newRecord(){
		System.out.println("InvitePaperTypeBean.newRecord()");
		tipoPapel = new TipoPapel();
		this.step = 1;
	}
	
	public void editRecord(){
		System.out.println("InvitePaperTypeBean.editRecord()");
		this.step = 1;
	}
	
	public void saveRecord(){
		System.out.println("InvitePaperTypeBean.saveRecord()");
		
		tipoPapel = tipoPapelService.save(tipoPapel);
		if(tipoPapel != null){
			if(!listaTipoPapel.contains(tipoPapel))
				listaTipoPapel.add(tipoPapel);
			
			this.step = 0;
			
			growl.addInfoMessage("gravacao.sucesso");
		} else {
			growl.addErrorMessage("gravacao.erro");
		}
	}
	
	public void cancel(){
		System.out.println("InvitePaperTypeBean.cancel()");
		this.step = 0;
	}
	
	public void deleteRecord(){
		System.out.println("InvitePaperTypeBean.deleteRecord()");
		System.out.println(tipoPapel);
		
		if(tipoPapelService.remove(tipoPapel)){
			listaTipoPapel.remove(tipoPapel);
			
			growl.addInfoMessage("remocao.sucesso");
		} else {
			growl.addErrorMessage("remocao.erro");
		}
		
		this.step = 0;
	}

	/* -- Getters and Setters */
	
	public TipoPapel getTipoPapel() {
		return tipoPapel;
	}

	public void setTipoPapel(TipoPapel tipoPapel) {
		this.tipoPapel = tipoPapel;
	}

	public List<TipoPapel> getListaTipoPapel() {
		return listaTipoPapel;
	}

	public void setListaTipoPapel(List<TipoPapel> listaTipoPapel) {
		this.listaTipoPapel = listaTipoPapel;
	}
	
	public String getLabel() {
		return tipoPapel.getId().equals(new Long(0)) ? "novo.tipo.papel" : "tipo.papel.editar";
	}
}
