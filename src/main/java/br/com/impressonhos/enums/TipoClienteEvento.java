package br.com.impressonhos.enums;

/**
 * Enum responsável pelos possíveis tipos clientes do evento. Ex.:
 * <ul>
 * 	<li>ANIVERSARIANTE</li>
 * 	<li>MAE_ANIVERSARIANTE</li>
 * 	<li>NOIVA</li>
 * 	<li>PAI_NOIVA</li>
 * </ul>
 * @author riccardof
 *
 */
public enum TipoClienteEvento {
	ANIVERSARIANTE(0),
	MAE_ANIVERSARIANTE(1),
	PAI_ANIVERSARIANTE(2),
	NOIVA(3),
	MAE_NOIVA(4),
	PAI_NOIVA(5),
	NOIVO(6),
	MAE_NOIVO(7),
	PAI_NOIVO(8);
	
	private Integer tipo;
	
	TipoClienteEvento(Integer tipo){
		this.tipo = tipo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
}
