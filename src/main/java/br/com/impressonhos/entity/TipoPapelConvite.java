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
@Table(name = "TIPO_PAPEL_CONVITE", schema = Const.SCHEMA)
public class TipoPapelConvite implements Serializable {

	private static final long serialVersionUID = -8194782424580952168L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_PAPEL_CONVITE_ID")
	private long id;
	
	@Column(name = "TIPO", nullable=false)
	private String tipo;

	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		TipoPapelConvite other = (TipoPapelConvite) obj;
		if (id != other.id)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TipoPapelConvite [id=" + id + ", tipo=" + tipo + "]";
	}
}