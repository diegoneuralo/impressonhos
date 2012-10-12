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

	private static final long serialVersionUID = 5852155257603780968L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contratante == null) ? 0 : contratante.hashCode());
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ (int) (numeroContrato ^ (numeroContrato >>> 32));
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
		if (contratante == null) {
			if (other.contratante != null)
				return false;
		} else if (!contratante.equals(other.contratante))
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (id != other.id)
			return false;
		if (numeroContrato != other.numeroContrato)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", numeroContrato=" + numeroContrato
				+ ", contratante=" + contratante + ", evento=" + evento + "]";
	}
}
