package br.com.impressonhos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.impressonhos.enums.Const;

@Entity
@Table(name = "AGREGADO_EVENTO", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "AgregadoEvento.getByEvento", 
			query = "from AgregadoEvento me where me.evento.id = ?")
	})
public class AgregadoEvento implements Serializable {

	private static final long serialVersionUID = -3135808056759253781L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACESSORIO_EVENTO_ID")
	private long id;
	
	@Column(name = "ITEM_EVENTO_ID", nullable=false)
	private ItemEvento acessorio;
	
	@Column(name = "QTD", length = 5, nullable=false)
	private Integer quantidade;
	
	@Column(name = "VALOR_UN", nullable=false)
	private BigDecimal valor;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ENTREGA", nullable = false)
	private Date dataEntrega;
	
	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable=false)	
	private Evento evento;

	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public ItemEvento getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(ItemEvento acessorio) {
		this.acessorio = acessorio;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}	
	
	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	@Transient
	public BigDecimal getValorTotal() {
		BigDecimal qtd = new BigDecimal(quantidade);
		return qtd.multiply(valor).setScale(2,RoundingMode.HALF_EVEN);
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
		AgregadoEvento other = (AgregadoEvento) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AcessorioEvento [id=" + id + ", acessorio=" + acessorio
				+ ", quantidade=" + quantidade + ", valor=" + valor.setScale(2, RoundingMode.HALF_EVEN)
				+ ", evento=" + evento + "]";
	}	
}