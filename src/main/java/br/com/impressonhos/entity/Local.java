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

@SuppressWarnings("serial")
@Entity
@Table(name = "LOCAL", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Local.getByPessoa", 
			query = "from Local l where l.pessoa.id = ?"),
	@NamedQuery(
			name = "Local.getByCpfCnpj", 
			query = "from Local l where trim(l.cpfCnpj) = ?")
	})
public class Local implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCAL_ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "PESSOA_ID", referencedColumnName = "PESSOA_ID", nullable = false)	
	private Pessoa pessoa;
	
	@Column(name = "CPF_CNPJ", nullable = true, length = 14)
	private String cpfCnpj;
	
	// contato_id nao existe em pessoa
//	@ManyToOne
//	@JoinColumn(name = "CONTATO_ID", referencedColumnName = "CONTATO_ID", nullable = false)	
//	private Pessoa contato;
	
	// ------------------------------------------------------------------------------- //
	
	public Local()
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

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
//	public Pessoa getContato() {
//		return contato;
//	}
//
//	public void setContato(Pessoa contato) {
//		this.contato = contato;
//	}

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
		Local other = (Local) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Local [id=" + id + "]";
	}
	
}
