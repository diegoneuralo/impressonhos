package br.com.impressonhos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.impressonhos.enums.Const;

@Entity
@Table(name = "MODELO_CONVITE", schema = Const.SCHEMA)
public class ModeloConvite implements Serializable {

	private static final long serialVersionUID = -5584048707427792359L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODELO_CONVITE_ID")
	private long id;
	
	@Column(name = "NOME", nullable=false)
	private String nome;
	
	@Column(name = "DESCRICAO", length = 255, nullable=false)
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		ModeloConvite other = (ModeloConvite) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ModeloConvite [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + "]";
	}
}