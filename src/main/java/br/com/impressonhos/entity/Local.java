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
import javax.persistence.UniqueConstraint;

import br.com.impressonhos.enums.Const;

@Entity
@Table(
		name = "LOCAL", 
		schema = Const.SCHEMA,
		uniqueConstraints = { 
				@UniqueConstraint(columnNames = { "CPF_CNPJ" })
		}
	)
@NamedQueries({ 
	@NamedQuery(
			name = "Local.getByPessoa", 
			query = "from Local l where l.pessoa.id = ?"),
	@NamedQuery(
			name = "Local.getByCpfCnpj", 
			query = "from Local l where trim(l.cpfCnpj) = ?")
	})

/**
 * Cadastro do local onde será realizado o evento. Caso o local não seja um que já esteja pré cadastrado
 * ou seja uma local próprio, o mesmo utilizará o cpf/cnpj e a Pessoa do Contratante para armazenar os dados.
 * @author riccardof
 *
 */
public class Local implements Serializable {

	private static final long serialVersionUID = -1841414619761750433L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCAL_ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "PESSOA_ID", referencedColumnName = "PESSOA_ID", nullable = false)	
	private Pessoa pessoa;
	
	@Column(name = "CPF_CNPJ", nullable = true, length = 14)
	private String cpfCnpj;
	
	@ManyToOne
	@JoinColumn(name = "CONTATO_ID", referencedColumnName = "PESSOA_ID", nullable = false)	
	private Pessoa contato;
	
	@Column(name = "IS_LOCAL_PROPRIO")
	private Boolean localProprio;
	
	// ------------------------------------------------------------------------------- //
	
	/**
	 * Preenche por default o local como não próprio, caso o cliente deseje utilizar esta
	 * opção ele dever selecionar por conta própria.
	 */
	public Local(){
		this.localProprio = Boolean.FALSE;
	}
	
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
	
	public Pessoa getContato() {
		return contato;
	}

	public void setContato(Pessoa contato) {
		this.contato = contato;
	}

	public Boolean getLocalProprio() {
		return localProprio;
	}

	public void setLocalProprio(Boolean localProprio) {
		this.localProprio = localProprio;
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
