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

/**
 * @TODO Perguntar para o rafael como faço para "pegar" o endereço e o telefone de uma pessoa através
 * da própria entidade Pessoa - acho que é um @OneToMany - mas não tenho certeza de como funciona isso.
 */

@Entity
@Table(
		name = "PESSOA", 
		schema = Const.SCHEMA, 
		uniqueConstraints = { 
				@UniqueConstraint(columnNames = { "NOME", "RG" }),
				@UniqueConstraint(columnNames = { "EMAIL" })
		})
@NamedQueries({ 
	@NamedQuery(
			name = "Pessoa.getByNameAndRg", 
			query = "from Pessoa p where trim(upper(p.nome)) like upper('%?%') and trim(p.rg) = ?")
	})
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 5015962732440974008L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PESSOA_ID")
	private Long id;

	@Column(name = "NOME", nullable = false, length = 60)
	private String nome;

	@Column(name = "RG", nullable = false)
	private String rg;
	
	@Column(name = "EMAIL", nullable = true)
	private String email;

	/**
	 * Tipo da Pessoa: Física ou Jurídica?
	 */
	@Column(name = "TIPO", nullable = true)
	private String tipo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CADASTRO", nullable = false)
	private Date dataCadastro;

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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
