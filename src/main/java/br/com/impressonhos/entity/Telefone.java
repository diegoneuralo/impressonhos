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
@Table(name = "TELEFONE", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Telefone.getByPessoa", 
			query = "from Telefone t where t.pessoa.id = ?"),
	})
public class Telefone implements Serializable {

	private static final long serialVersionUID = -4009151363117100319L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TELEFONE_ID")
	private long id;
	
	@Column(name = "COD_AREA", length = 2, nullable=false)
	private String codArea;
	
	@Column(name = "TELEFONE", length = 8, nullable=false)
	private int telefone;
	
	@Column(name = "RAMAL", length = 5, nullable=true)
	private int numero;
	
	/**
	 * Define o tipo do telefone, respeitando uma das opções abaixo
	 * <ul>
	 * 	<li>Residêncial</li>
	 * 	<li>Celular</li>	
	 * 	<li>Comercial</li>
	 * 	<li>Recados</li>
	 * </ul> 
	 */
	@Column(name = "TIPO", length = 1, nullable=false)
	private int tipo;
	
	@ManyToOne
	@JoinColumn(name = "PESSOAID_ID", referencedColumnName = "PESSOAID_ID", nullable=false)	
	private Pessoa pessoa;

	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public String getCodArea() {
		return codArea;
	}

	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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
		result = prime * result + numero;
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + tipo;
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
		Telefone other = (Telefone) obj;
		if (id != other.id)
			return false;
		if (numero != other.numero)
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", codArea=" + codArea + ", telefone="
				+ telefone + ", numero=" + numero + ", tipo=" + tipo
				+ ", pessoa=(id:" + pessoa.getId() + ") " + pessoa.getNome() + "]";
	}
	
	
}
