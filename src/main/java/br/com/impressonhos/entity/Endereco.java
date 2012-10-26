package br.com.impressonhos.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import br.com.impressonhos.enums.TipoEndereco;

@Entity
@Table(
		name = "ENDERECO", 
		schema = Const.SCHEMA, 
		uniqueConstraints={
				@UniqueConstraint(columnNames = { "CEP", "PESSOA_ID", "TIPO_ENDERECO" })
			})
@NamedQueries({ 
	@NamedQuery(
			name = "Endereco.getByPessoaAndTipoEndereco", 
			query = "from Endereco e where e.pessoa.id = ? and e.tipoEndereco = ?"),
	})
public class Endereco implements Serializable {

	private static final long serialVersionUID = -1908918372813761039L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ENDERECO_ID")
	private long id;
	
	@Column(name = "LOGRADOURO", length = 255, nullable = false)
	private String logradouro;
	
	/**
	 * O tipo do logradouro refere-se ao tipo padrão dos correios, como por exemplo: 
	 * rua, avenida, travessa, etc..
	 */
	@ManyToOne
	@JoinColumn(name = "LOGRADOURO_ID", referencedColumnName = "LOGRADOURO_ID", nullable = false)
	private TipoLogradouro tipoLogradouro;
	
	@Column(name = "NUMERO", length = 10, nullable=false)
	private int numero;
	
	@Column(name = "CEP", length = 9, nullable=false)
	private String cep;
	
	@Column(name = "BAIRRO", length = 60, nullable=false)
	private String bairro;
	
	@Column(name = "CIDADE", length = 60, nullable=false)
	private String cidade;
	
	@ManyToOne
	@JoinColumn(name = "UF_ID", referencedColumnName = "UF_ID", nullable=false)	
	private Uf uf;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PESSOA_ID", referencedColumnName = "PESSOA_ID", nullable=false)	
	private Pessoa pessoa;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TIPO_ENDERECO", length = 1, nullable=false)
	private TipoEndereco tipoEndereco;

	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
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
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + numero;
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
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro
				+ ", numero=" + numero + ", cep=" + cep + "bairro=" 
				+ bairro + ", cidade=" + cidade + ", uf=" + uf 
				+ ", pessoa=(id:" +pessoa.getId() + ") - " 
				+ pessoa.getNome() + ", tipoEndereco=" + tipoEndereco + "]";
	}
}
