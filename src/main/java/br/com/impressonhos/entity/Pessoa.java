package br.com.impressonhos.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import br.com.impressonhos.enums.Const;

@Entity
@Table(name = "PESSOA", schema = Const.SCHEMA, uniqueConstraints = { @UniqueConstraint(columnNames = { "NOME", "RG" }) })
@NamedQueries({ 
	@NamedQuery(
			name = "Pessoa.getByNameAndRg", 
			query = "from Pessoa p where trim(upper(p.nome)) like upper('%?%') and trim(p.rg) = ?"),
	})
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = -5431036179408590375L;

	public Pessoa() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PESSOA_ID")
	private Long id;

	@Column(name = "NOME", nullable = false, length = 60)
	private String nome;

	@Column(name = "RG", nullable = true)
	private String rg;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CADASTRO", nullable = false)
	private Date dataCadastro;

	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataCadastro() {
		return dataCadastro;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		return "Pessoa [id=" + id + ", nome=" + nome + ", rg=" + rg
				+ ", dataCadastro=" + sdf.format(dataCadastro) + "]";
	}	
}
