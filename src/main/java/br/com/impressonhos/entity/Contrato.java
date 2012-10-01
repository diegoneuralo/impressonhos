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

/** @TODO Criar a entidade Evento e gerar os gets e sets + hashCode and Equals + toString aqui */

@Entity
@Table(name = "CONTRATANTE", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Contrato.getByEvento", 
			query = "from Contrato c where c.evento.id = ?"),
	@NamedQuery(
			name = "Contrato.getByPessoa", 
			query = "from Contrato c where c.contratante.pessoa.id = ?"),
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
	
	/*@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable=false)	
	private Evento evento;*/
	
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
	
}
