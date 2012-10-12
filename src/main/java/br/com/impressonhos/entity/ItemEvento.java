package br.com.impressonhos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.impressonhos.enums.Const;
import br.com.impressonhos.enums.TipoItemEvento;

@Entity
@Table(name = "ITEM_EVENTO", schema = Const.SCHEMA)
public class ItemEvento implements Serializable {

	private static final long serialVersionUID = 8270631621811922656L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_EVENTO_ID")
	private long id;
	
	@Column(name = "NOME", nullable=false)
	private String nome;
	
	@Column(name = "TIPO", length = 2, nullable=false)
	private TipoItemEvento tipo;

	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoItemEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoItemEvento tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		ItemEvento other = (ItemEvento) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemEvento [id=" + id + ", nome=" + nome + ", tipo=" + tipo
				+ "]";
	}	
}