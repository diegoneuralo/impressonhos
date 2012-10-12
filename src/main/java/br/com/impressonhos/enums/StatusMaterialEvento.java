package br.com.impressonhos.enums;

/**
 * Enum responsável pelos status de compra do evento. Opções:
 * <ul>
 * 	<li>COMPRADO</li>
 * 	<li>NAO_COMPRADO</li>
 * </ul>
 * @author riccardof
 *
 */
public enum StatusMaterialEvento {
	COMPRADO(0),
	NAO_COMPRADO(1);
	
	private Integer tipo;
	
	StatusMaterialEvento(Integer tipo){
		this.tipo = tipo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
}
