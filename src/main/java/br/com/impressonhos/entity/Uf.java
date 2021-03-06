package br.com.impressonhos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.impressonhos.enums.Const;

@Entity
@Table(name = "UF", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Uf.getBySigla", 
			query = "from Uf u where trim(upper(u.sigla)) = upper(?)")
	})
public class Uf implements Serializable {

	private static final long serialVersionUID = -3660576804157028913L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UF_ID")
	private long id;
	
	@Column(name = "SIGLA", length = 2, nullable=false)
	private String sigla;
	
	@Column(name = "ESTADO", length = 30, nullable=false)
	private String estado;

	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
		Uf other = (Uf) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", sigla=" + sigla + "]";
	}
	
}
