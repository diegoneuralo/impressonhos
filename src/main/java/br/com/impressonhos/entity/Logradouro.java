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
@Table(name = "LOGRADOURO", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Logradouro.getByAbreviatura", 
			query = "from Logradouro l where trim(l.abreviatura) like trim('%?%')")
	})
public class Logradouro implements Serializable {

	private static final long serialVersionUID = -1503464372538643622L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOGRADOURO_ID")
	private long id;
	
	@Column(name = "ABREVIATURA", length = 5, nullable=true)
	private String abreviatura;
	
	@Column(name = "LOGRADOURO", length = 30, nullable=false)
	private String logradouro;

	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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
		Logradouro other = (Logradouro) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Logradouro [id=" + id + ", logradouro=" + logradouro + "]";
	}
	
}