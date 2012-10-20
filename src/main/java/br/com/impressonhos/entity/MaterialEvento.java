package br.com.impressonhos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.impressonhos.enums.Const;
import br.com.impressonhos.enums.StatusMaterialEvento;

@SuppressWarnings("serial")
@Entity
@Table(name = "MATERIAL_EVENTO", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "MaterialEvento.getByEvento", 
			query = "from MaterialEvento me where me.evento.id = ?")
	})
public class MaterialEvento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MATERIAL_EVENTO_ID")
	private long id;
	
	@Column(name = "ITEM_EVENTO_ID", nullable=false)
	private ItemEvento material;
	
	@Column(name = "QTD", length = 5, nullable=false)
	private Integer quantidade;
	
	@Column(name = "STATUS", length = 1, nullable=false)
	private StatusMaterialEvento status;
	
	@Column(name = "EVENTO_ID", nullable=false)
	private Evento evento;

	// ------------------------------------------------------------------------------- //
	
	public MaterialEvento() 
	{}
	
	public Long getId() {
		return id;
	}

	public ItemEvento getMaterial() {
		return material;
	}

	public void setMaterial(ItemEvento material) {
		this.material = material;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public StatusMaterialEvento getStatus() {
		return status;
	}

	public void setStatus(StatusMaterialEvento status) {
		this.status = status;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
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
		MaterialEvento other = (MaterialEvento) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MaterialEvento [id=" + id + ", material=" + material
				+ ", quantidade=" + quantidade + ", status=" + status
				+ ", evento=" + evento + "]";
	}	
}