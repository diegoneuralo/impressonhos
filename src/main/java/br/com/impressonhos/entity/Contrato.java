package br.com.impressonhos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.impressonhos.enums.Const;

@SuppressWarnings("serial")
@Entity
@Table(name = "CONTRATO", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Contrato.getByEvento", 
			query = "from Contrato c where c.evento.id = ?"),
	@NamedQuery(
			name = "Contrato.getByPessoa", 
			query = "from Contrato c where c.contratante.pessoa.id = ?"),
	@NamedQuery(
			name = "Contrato.getByContratante", 
			query = "from Contrato c where c.contratante.id = ?")
	})
public class Contrato implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTRATO_ID")
	private long id;

	@Column(name = "NUMERO_CONTRATO")
	private long numeroContrato;
	
	@ManyToOne
	@JoinColumn(name = "CONTRATANTE_ID", referencedColumnName = "CONTRATANTE_ID", nullable=false)	
	private Contratante contratante;
	
	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable=false)	
	private Evento evento;
	
	// ------------------------------------------------------------------------------- //
	public Contrato()
	{}
	
	public void setId(long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public long getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(long numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Contrato other = (Contrato) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + "]";
	}
	
}
