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
@Table(name = "ENDERECO", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Endereco.getByPessoa", 
			query = "from Endereco e where e.pessoa.id = ?"),
	})
public class Endereco implements Serializable {

	private static final long serialVersionUID = -2829484707862037622L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ENDERECO_ID")
	private long id;
	
	@Column(name = "LOGRADOURO", length = 60)
	private String logradouro;
	
	/**
	 * O tipo do logradouro refere-se ao tipo padrão dos correios, como por exemplo: 
	 * rua, avenida, travessa, etc..
	 */
	@Column(name = "TIPO_LOGRADOURO", length = 2)
	private int tipoLogradouro;
	
	@Column(name = "NUMERO", length = 10)
	private int numero;
	
	@Column(name = "BAIRRO", length = 60)
	private String bairro;
	
	@Column(name = "CIDADE", length = 60)
	private String cidade;
	
	@ManyToOne
	@JoinColumn(name = "UF_ID", referencedColumnName = "UF_ID")	
	private Uf uf;
	
	@ManyToOne
	@JoinColumn(name = "PESSOAID_ID", referencedColumnName = "PESSOAID_ID")	
	private Pessoa pessoa;
	
	/**
	 * O tipo do endereço refere-se uma das seguintes opçoes:
	 * <ul>
	 * 	<li>Receptivo</li>
	 * 	<li>Cerimonial</li>
	 * 	<li>Residêncial</li>
	 * 	<li>Comercial</li>
	 * </ul>
	 */
	@Column(name = "TIPO_ENDERECO", length = 1)
	private String tipoEndereco;

	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(int tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(String tipoEndereco) {
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
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + numero;
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result
				+ ((tipoEndereco == null) ? 0 : tipoEndereco.hashCode());
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
		if (id != other.id)
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numero != other.numero)
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (tipoEndereco == null) {
			if (other.tipoEndereco != null)
				return false;
		} else if (!tipoEndereco.equals(other.tipoEndereco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro
				+ ", numero=" + numero + ", bairro=" + bairro + ", cidade="
				+ cidade + ", uf=" + uf + ", pessoa=(id:" +pessoa.getId() 
				+ ") - " + pessoa.getNome() + ", tipoEndereco=" 
				+ tipoEndereco + "]";
	}
	
	
}
