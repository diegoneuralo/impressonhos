package br.com.impressonhos.entity;

import java.io.Serializable;

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
import javax.persistence.Transient;

import br.com.impressonhos.enums.Const;
import br.com.impressonhos.enums.TipoTelefone;

@Entity
@Table(name = "TELEFONE", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Telefone.getByPessoa", 
			query = "from Telefone t where t.pessoa.id = ?"),
	})
public class Telefone implements Serializable {

	private static final long serialVersionUID = -4104712014406159968L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TELEFONE_ID")
	private long id;
	
	@Column(name = "COD_AREA", length = 2, nullable=false)
	private String codArea;
	
	@Column(name = "TELEFONE", length = 9, nullable=false)
	private int telefone;
	
	@Column(name = "RAMAL", length = 5, nullable=true)
	private int ramal;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TIPO", length = 1, nullable=false)
	private TipoTelefone tipo;
	
	@ManyToOne
	@JoinColumn(name = "PESSOA_ID", referencedColumnName = "PESSOA_ID", nullable=false)	
	private Pessoa pessoa;

	@Transient
	private String maskedPhone;
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

	public int getRamal() {
		return ramal;
	}

	public void setRamal(int ramal) {
		this.ramal = ramal;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String getMaskedPhone() {
		return maskedPhone;
	}

	public void setMaskedPhone(String maskedPhone) {
		this.maskedPhone = maskedPhone;
		this.codArea = maskedPhone.substring(1, 3);
		this.telefone = Integer.parseInt(maskedPhone.substring(4).trim().replace("-", ""));
		System.out.println("Telefone.setMaskedPhone()");
		System.out.println(" - codArea: "+this.codArea);
		System.out.println(" - telefone: "+this.telefone);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codArea == null) ? 0 : codArea.hashCode());
		result = prime * result + ramal;
		result = prime * result + telefone;
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
		if (codArea == null) {
			if (other.codArea != null)
				return false;
		} else if (!codArea.equals(other.codArea))
			return false;
		if (ramal != other.ramal)
			return false;
		if (telefone != other.telefone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", codArea=" + codArea + ", telefone="
				+ telefone + ", ramal=" + ramal + ", tipo=" + tipo
				+ ", pessoa=(id:" + pessoa.getId() + ") " + pessoa.getNome() + "]";
	}
}
