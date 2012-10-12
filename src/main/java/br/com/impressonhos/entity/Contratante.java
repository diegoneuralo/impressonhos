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
@Table(name = "CONTRATANTE", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Contratante.getByPessoa", 
			query = "from Contratante c where c.pessoa.id = ?"),
	@NamedQuery(
			name = "Contratante.getByCpfCnjp", 
			query = "from Contratante c where trim(cpfCnpj) = ?"),
	})
public class Contratante implements Serializable {

	private static final long serialVersionUID = 7589623023631406700L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTRATANTE_ID")
	private long id;
	
	@Column(name = "CPF_CNPJ", length = 14, nullable=false)
	private String cpfCnpj;
	
	@Column(name = "COMO_CHEGOU", length = 30, nullable=false)
	private String comoChegou;
	
	@ManyToOne
	@JoinColumn(name = "PESSOAID_ID", referencedColumnName = "PESSOAID_ID", nullable=false)	
	private Pessoa pessoa;

	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getComoChegou() {
		return comoChegou;
	}

	public void setComoChegou(String comoChegou) {
		this.comoChegou = comoChegou;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		Contratante other = (Contratante) obj;
		if (cpfCnpj == null) {
			if (other.cpfCnpj != null)
				return false;
		} else if (!cpfCnpj.equals(other.cpfCnpj))
			return false;
		if (id != other.id)
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contratante [id=" + id + ", cpfCnpj=" + cpfCnpj 
				+ ", pessoa=(id: "+pessoa.getId() + ") " + pessoa.getNome() + "]";
	}

	
}
