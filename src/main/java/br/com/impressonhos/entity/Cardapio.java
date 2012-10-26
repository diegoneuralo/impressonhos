package br.com.impressonhos.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.impressonhos.enums.Const;
import br.com.impressonhos.enums.StatusCardapio;

@Entity
@Table(name = "CARDAPIO", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Cardapio.getByEvento", 
			query = "from Cardapio c where c.evento.id = ?")
	})
public class Cardapio implements Serializable {

	private static final long serialVersionUID = -6328680727564136582L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARDAPIO_ID")
	private long id;

	@Column(name = "ARTE_FINAL_APROVADA", nullable=false)
	private boolean arteFinalAprovada;
	
	@Column(name = "MATERIAIS_COMPRADOS", nullable=false)
	private boolean materiaisComprados;
	
	@Column(name = "DADOS_RECEBIDOS", nullable=false)
	private boolean dadosRecebidos;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "STATUS", nullable=false)
	private StatusCardapio status;
	
	@Lob
	@Column(name = "OBSERVACOES", length=500, nullable=false)
	private String observacoes;
	
	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable=false)	
	private Evento evento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ENTREGA")
	private Date dataEntrega;
	
	// ------------------------------------------------------------------------------- //

	public Long getId() {
		return id;
	}

	public boolean isArteFinalAprovada() {
		return arteFinalAprovada;
	}

	public void setArteFinalAprovada(boolean arteFinalAprovada) {
		this.arteFinalAprovada = arteFinalAprovada;
	}

	public boolean isMateriaisComprados() {
		return materiaisComprados;
	}

	public void setMateriaisComprados(boolean materiaisComprados) {
		this.materiaisComprados = materiaisComprados;
	}

	public boolean isDadosRecebidos() {
		return dadosRecebidos;
	}

	public void setDadosRecebidos(boolean dadosRecebidos) {
		this.dadosRecebidos = dadosRecebidos;
	}

	public StatusCardapio getStatus() {
		return status;
	}

	public void setStatus(StatusCardapio status) {
		this.status = status;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cardapio other = (Cardapio) obj;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cardapio [id=" + id + ", arteFinalAprovada="
				+ arteFinalAprovada + ", materiaisComprados="
				+ materiaisComprados + ", dadosRecebidos=" + dadosRecebidos
				+ ", status=" + status + ", evento=" + evento + "]";
	}
	
}