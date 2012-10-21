package br.com.impressonhos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.impressonhos.enums.Const;
import br.com.impressonhos.enums.TipoClienteEvento;

@SuppressWarnings("serial")
@Entity
@Table(name = "CLIENTE_EVENTO", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "ClienteEvento.getByPessoa", 
			query = "from ClienteEvento ce where ce.pessoa.id = ?")
	})
public class ClienteEvento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENTE_EVENTO_ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "PESSOA_ID", referencedColumnName = "PESSOA_ID", nullable=false)
	private Pessoa pessoa;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TIPO", length = 2, nullable=false)
	private TipoClienteEvento tipo;
	
	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable=false)	
	private Evento evento;
	
	public ClienteEvento()
	{}

	public Long getId() {
		return id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoClienteEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoClienteEvento tipo) {
		this.tipo = tipo;
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
		ClienteEvento other = (ClienteEvento) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteEvento [id=" + id + ", tipo=" + tipo + "]";
	}
	
}