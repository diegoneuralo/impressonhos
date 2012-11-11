package br.com.impressonhos.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import br.com.impressonhos.enums.Const;
import br.com.impressonhos.enums.TipoPessoa;
import br.com.impressonhos.util.exception.ObjectAlreadyExistsException;

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
			query = "from Pessoa p where trim(upper(p.nome)) like upper('%?%') and trim(p.rg) = ?"),
	@NamedQuery(
			name = "Pessoa.getByNameAndEmail", 
			query = "from Pessoa p where trim(upper(p.nome)) like upper('%?%') and trim(p.email) = lower('%?%')"),
	@NamedQuery(
			name = "Pessoa.getByEmail", 
			query = "from Pessoa p where trim(p.email) like trim('%?%')")
	})
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 3279306335617207095L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PESSOA_ID")
	private Long id;

	@Column(name = "NOME", nullable = false, length = 60)
	private String nome;

	@Column(name = "RG", nullable = true)
	private String rg;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;

	/**
	 * Tipo da Pessoa: Física ou Jurídica?
	 */
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TIPO", nullable = false)
	private TipoPessoa tipo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CADASTRO", nullable = false)
	private Date dataCadastro;
	
	@Column(name = "IS_PROSPECT", nullable = false)
	private boolean prospect;
	
	@OneToMany(mappedBy="pessoa", cascade = CascadeType.ALL)
	//@JoinColumn(name = "PESSOA_ID")
	private List<Endereco> enderecos;
	
	@OneToMany(mappedBy="pessoa", cascade = CascadeType.ALL)
	//@JoinColumn(name = "PESSOA_ID")
	private List<Telefone> telefones;
 
	// ------------------------------------------------------------------------------- //
	
	public Pessoa() {
		this.dataCadastro = new Date(System.currentTimeMillis());
	}
	
	public List<Endereco> addEndereco(Endereco endereco) throws ObjectAlreadyExistsException{
		if(this.enderecos.contains(endereco)) throw new ObjectAlreadyExistsException("endereco.ja.cadastrado");
		this.enderecos.add(endereco);
		return this.enderecos;
	}
	
	public List<Endereco> removeEndereco(Endereco endereco) throws NoResultException{
		if(!this.enderecos.remove(endereco)) throw new NoResultException("endereco.nao.encontrado.impossivel.remocao");	
		return this.enderecos;
	}
	
	public List<Telefone> addEndereco(Telefone telefone) throws ObjectAlreadyExistsException{
		if(this.telefones.contains(telefone)) throw new ObjectAlreadyExistsException("telefone.ja.cadastrado");
		this.telefones.add(telefone);
		return this.telefones;
	}
	
	public List<Telefone> removeEndereco(Telefone telefone) throws NoResultException{
		if(!this.telefones.remove(telefone)) throw new NoResultException("telefone.nao.encontrado.impossivel.remocao");	
		return this.telefones;
	}
	
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

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
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

	public boolean isProspect() {
		return prospect;
	}

	public void setProspect(boolean prospect) {
		this.prospect = prospect;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
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
