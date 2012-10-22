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
@Table(name = "CONVIDADO", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Convidado.getByEvento", 
			query = "from Convidado c where c.evento.id = ?")
	})
public class Convidado implements Serializable {

	private static final long serialVersionUID = -2134624002002071538L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONVIDADO_ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "PESSOA_ID", referencedColumnName = "PESSOA_ID", nullable=false)	
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable=false)	
	private Evento evento;
	
	// ------------------------------------------------------------------------------- //

	public Long getId() {
		return id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		Convidado other = (Convidado) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Convidado [id=" + id + ", pessoa=" + pessoa + "]";
	}
}