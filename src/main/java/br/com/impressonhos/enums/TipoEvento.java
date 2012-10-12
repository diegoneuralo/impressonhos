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
	CASAMENTO(0),
	CORPORATIVO(1),
	FESTA_15_ANOS(2);
	
	private Integer tipo;
	
	TipoEvento(Integer tipo){
		this.tipo = tipo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
}
