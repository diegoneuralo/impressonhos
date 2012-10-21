package br.com.impressonhos.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.persistence.UniqueConstraint;

import br.com.impressonhos.enums.Const;
import br.com.impressonhos.enums.TipoEvento;

@SuppressWarnings("serial")
@Entity
@Table(
		name = "EVENTO", 
		schema = Const.SCHEMA, 
		uniqueConstraints = { 
				@UniqueConstraint(columnNames = { "CONTRATANTE_ID", "LOCAL_ID", "DATA_EVENTO" }) 
			})
@NamedQueries({ 
	@NamedQuery(
			name = "Evento.getByContratante", 
			query = "from Evento e where e.contratante.id = ? "),
	@NamedQuery(
			name = "Evento.getByPeriodoInicioFim", 
			query = "from Evento e where e.dataEvento >= ? and e.dataEvento <= ? ")
	})
public class Evento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENTO_ID")
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TIPO", nullable = false)
	private TipoEvento tipo;
	
	@ManyToOne
	@JoinColumn(name = "LOCAL_ID", referencedColumnName = "LOCAL_ID", nullable=false)	
	private Local local;
	
	@ManyToOne
	@JoinColumn(name = "CONTRATANTE_ID", referencedColumnName = "CONTRATANTE_ID", nullable=false)
	private Contratante contratante;
	
	@ManyToOne
	@JoinColumn(name = "CERIMONIALISTA_ID", referencedColumnName = "CERIMONIALISTA_ID", nullable=true)
	private Pessoa cerimonialista;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CADASTRO", nullable = false)
	private Date dataCadastro;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_EVENTO", nullable = false)
	private Date dataEvento;

	@Lob
	@Column(name = "OBSERVACOES", nullable = true, length=500)
	private String observacoes;

	// ------------------------------------------------------------------------------- //
	
	public Evento() {
		this.dataCadastro = new Date(System.currentTimeMillis());
	}
	
	public Long getId() {
		return id;
	}
	
	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public Pessoa getCerimonialista() {
		return cerimonialista;
	}

	public void setCerimonialista(Pessoa cerimonialista) {
		this.cerimonialista = cerimonialista;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
		return "Evento [id=" + id + ", tipo=" + tipo + ", local=" + local
				+ ", contratante=" + contratante + ", dataCadastro="
				+ sdf.format(dataCadastro) + ", dataEvento=" + sdf.format(dataEvento)
				+ ", observacoes=" + observacoes + "]";
	}
}