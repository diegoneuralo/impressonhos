package br.com.impressonhos.enums;

/**
 * Enum responsável pelos status atual do convite. Opções:
 * <ul>
 * 	<li>AGUARDANDO_ITENS</li>
 * 	<li>EM_PRODUCAO</li>
 * 	<li>PRODUZIDO</li>
 * 	<li>ENVIADO</li>
 * </ul>
 * @author riccardof
 *
 */
public enum StatusConvite {
	AGUARDANDO_ITENS(0, "aguardando.itens"),
	EM_PRODUCAO(1, "em.producao"),
	PRODUZIDO(2, "produzido"),
	ENVIADO(3, "enviado");
	
	private Integer tipo;
	private String descricao;
	
	StatusConvite(Integer tipo, String descricao){
		this.tipo = tipo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	public int toInt() {
		return this.tipo;
	}
	
	public static StatusConvite valueOf(int i) {
		switch (i) {
			case 0: return AGUARDANDO_ITENS;
			case 1: return EM_PRODUCAO;
			case 2: return PRODUZIDO;
			case 3: return ENVIADO;
			default: return null;
		}
	}

	@Override
	public String toString() {
		return descricao;
	}
}
