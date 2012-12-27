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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.impressonhos.enums.Const;
import br.com.impressonhos.enums.UsoPapel;

@Entity
@Table(name = "TIPO_PAPEL_CONVITE", schema = Const.SCHEMA, 
	uniqueConstraints={
		@UniqueConstraint(columnNames={"TIPO_PAPEL_ID","USO_PAPEL","CONVITE_ID"})
	}
)
public class TipoPapelConvite implements Serializable {

	private static final long serialVersionUID = -4460418292051800139L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_PAPEL_CONVITE_ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "TIPO_PAPEL_ID", referencedColumnName = "TIPO_PAPEL_ID", nullable=false)	
	private TipoPapel tipoPapel;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "USO_PAPEL", nullable=false)
	private UsoPapel usoPapel;
	
	@ManyToOne
	@JoinColumn(name = "CONVITE_ID", referencedColumnName = "CONVITE_ID", nullable=false)	
	private Convite convite;

	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public TipoPapel getTipoPapel() {
		return tipoPapel;
	}

	public void setTipoPapel(TipoPapel tipoPapel) {
		this.tipoPapel = tipoPapel;
	}

	public UsoPapel getUsoPapel() {
		return usoPapel;
	}

	public void setUsoPapel(UsoPapel usoPapel) {
		this.usoPapel = usoPapel;
	}

	public Convite getConvite() {
		return convite;
	}

	public void setConvite(Convite convite) {
		this.convite = convite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((convite == null) ? 0 : convite.hashCode());
		result = prime * result
				+ ((tipoPapel == null) ? 0 : tipoPapel.hashCode());
		result = prime * result
				+ ((usoPapel == null) ? 0 : usoPapel.hashCode());
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
		TipoPapelConvite other = (TipoPapelConvite) obj;
		if (convite == null) {
			if (other.convite != null)
				return false;
		} else if (!convite.equals(other.convite))
			return false;
		if (tipoPapel == null) {
			if (other.tipoPapel != null)
				return false;
		} else if (!tipoPapel.equals(other.tipoPapel))
			return false;
		if (usoPapel != other.usoPapel)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoPapelConvite [id=" + id + ", tipoPapel=" + tipoPapel.getTipo() + 
									 ", usoPapel=" + usoPapel.getDescricao() + 
									 ", convite=" + convite + "]";
	}
}