package br.com.impressonhos.enums;

/**
 * Enum responsável pelos possíveis tipos de evento. Ex.:
 * <ul>
 * 	<li>CASAMENTO</li>
 * 	<li>CORPORATIVO</li>
 * 	<li>FESTA_15_ANOS</li>
 * </ul>
 * @author riccardof
 *
 */
public enum TipoEvento {
	CASAMENTO(0, "casamento"),
	CORPORATIVO(1, "corporativo"),
	FESTA_15_ANOS(2, "festa.15.anos");
	
	private Integer tipo;
	private String descricao;
	
	TipoEvento(Integer tipo, String descricao){
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int toInt() {
		return this.tipo;
	}
	
	public static TipoEvento valueOf(int i) {
		switch (i) {
			case 0: return CASAMENTO;
			case 1: return CORPORATIVO;
			case 2: return FESTA_15_ANOS;
			default: return null;
		}
	}

	@Override
	public String toString() {
		return descricao;
	}
}
