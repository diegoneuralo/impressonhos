package br.com.impressonhos.enums;

/**
 * Enum responsável pelos possíveis tipos de itens do evento. Opções:
 * <ul>
 * 	<li>ACABAMENTO</li>
 * 	<li>MATERIAL</li>
 * 	<li>ACESSORIOS</li>
 * </ul>
 * @author riccardof
 *
 */
public enum TipoItemEvento {
	ACABAMENTO(0),
	MATERIAL(1),
	ACESSORIOS(2);
	
	private Integer tipo;
	
	TipoItemEvento(Integer tipo){
		this.tipo = tipo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
}
