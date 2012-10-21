package br.com.impressonhos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.impressonhos.enums.Const;
import br.com.impressonhos.enums.StatusConvite;

@Entity
@Table(name = "CONVITE", schema = Const.SCHEMA)
@NamedQueries({ 
	@NamedQuery(
			name = "Convite.getByEvento", 
			query = "from Convite c where c.evento.id = ?")
	})
public class Convite implements Serializable {

	private static final long serialVersionUID = -3649085656820571749L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONVITE_ID")
	private long id;
	
	@Lob
	@Column(name = "MENSAGEM", length = 500, nullable=true)
	private String mensagem;
	
	@Column(name = "OBSERVACOES", length = 500, nullable=true)
	private String observacoes;
	
	@Column(name = "VALOR_UNITARIO", length = 5, nullable=false)
	private BigDecimal valorUnitario;
	
	@Column(name = "QUANTIDADE", length = 5, nullable=false)
	private Integer quantidade;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ENTREGA", nullable=false)
	private Date dataEntrega;
	
	@Column(name = "ARTE_FINAL_APROVADA", nullable=false)
	private boolean arteFinalAprovada;
	
	@Column(name = "MATERIAIS_COMPRADOS", nullable=false)
	private boolean materiaisComprados;
	
	@Column(name = "DADOS_RECEBIDOS", nullable=false)
	private boolean dadosRecebidos;
	
	@ManyToOne
	@JoinColumn(name = "MODELO_CONVITE_ID", referencedColumnName = "MODELO_CONVITE_ID", nullable=false)	
	private ModeloConvite modelo;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "STATUS", nullable=false)
	private StatusConvite status;

	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable=false)	
	private Evento evento;
	
	public Convite(){
		this.status = StatusConvite.AGUARDANDO_ITENS;
	}
	
	// TODO Conversar com o Dani sobre o tipo do papel.. o que significa isso?? as opções encontradas foram: Envelope, Interno e Forro.
	
	// ------------------------------------------------------------------------------- //
	
	public Long getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public boolean isArteFinalAprovada() {
		return arteFinalAprovada;
	}

	public void setArteFinalAprovada(boolean arteFinalAprovada) {
		this.arteFinalAprovada = arteFinalAprovada;
	}

	public boolean isMateriaisComprados() {
		return materiaisComprados;
	}

	public void setMateriaisComprados(boolean materiaisComprados) {
		this.materiaisComprados = materiaisComprados;
	}

	public boolean isDadosRecebidos() {
		return dadosRecebidos;
	}

	public void setDadosRecebidos(boolean dadosRecebidos) {
		this.dadosRecebidos = dadosRecebidos;
	}

	public ModeloConvite getModelo() {
		return modelo;
	}

	public void setModelo(ModeloConvite modelo) {
		this.modelo = modelo;
	}
	
	public StatusConvite getStatus() {
		return status;
	}

	public void setStatus(StatusConvite status) {
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
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
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
		Convite other = (Convite) obj;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Convite [id=" + id + ", dataEntrega=" + sdf.format(dataEntrega)
				+ ", arteFinalAprovada=" + arteFinalAprovada
				+ ", materiaisComprados=" + materiaisComprados
				+ ", dadosRecebidos=" + dadosRecebidos + ", modelo=" + modelo
				+ ", status=" + status + ", evento=" + evento + "]";
	}
	
	
}