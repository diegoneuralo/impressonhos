package br.com.impressonhos.controller.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.impressonhos.entity.TipoPapelConvite;
import br.com.impressonhos.service.TipoPapelConviteService;

@Named("invitePaper")
@ViewScoped
public class InvitePaperTypeBean extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject private TipoPapelConvite tipoPapel;
	@Inject private TipoPapelConviteService tipoPapelService;
	
	List<TipoPapelConvite> listaTipoPapelConvite;

	@PostConstruct
	public void construct(){
		System.out.println("InvitePaperTypeBean.construct()");
		listaTipoPapelConvite = tipoPapelService.findAll();
	}
	
	public void newRecord(){
		System.out.println("InvitePaperTypeBean.newRecord()");
		tipoPapel = new TipoPapelConvite();
		this.step = 1;
	}
	
	public void editRecord(){
		System.out.println("InvitePaperTypeBean.editRecord()");
		this.step = 1;
	}
	
	public void saveRecord(){
		System.out.println("InvitePaperTypeBean.saveRecord()");
		
		tipoPapel = tipoPapelService.save(tipoPapel);
		listaTipoPapelConvite.add(tipoPapel); 
		System.out.println(listaTipoPapelConvite);
		
		addInfoMessage(mbl.getMessage("gravacao.sucesso"));
		
		this.step = 0;
	}
	
	public void cancel(){
		System.out.println("InvitePaperTypeBean.cancel()");
		this.step = 0;
	}
	
	public void deleteRecord(){
		System.out.println("InvitePaperTypeBean.deleteRecord()");
		System.out.println(tipoPapel);
		
		tipoPapelService.remove(tipoPapel);
		listaTipoPapelConvite.remove(tipoPapel);
		
		addInfoMessage("remocao.sucesso");
		
		this.step = 0;
	}

	/* -- Getters and Setters */
	
	public TipoPapelConvite getTipoPapelConvite() {
		return tipoPapel;
	}

	public void setTipoPapelConvite(TipoPapelConvite tipoPapel) {
		this.tipoPapel = tipoPapel;
	}

	public List<TipoPapelConvite> getListaTipoPapelConvite() {
		return listaTipoPapelConvite;
	}

	public void setListaTipoPapelConvite(List<TipoPapelConvite> listaTipoPapelConvite) {
		this.listaTipoPapelConvite = listaTipoPapelConvite;
	}
}
