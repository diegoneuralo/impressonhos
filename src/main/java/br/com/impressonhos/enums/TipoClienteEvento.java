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
	ANIVERSARIANTE(0, "aniversariante"),
	MAE_ANIVERSARIANTE(1, "mae.aniversariante"),
	PAI_ANIVERSARIANTE(2, "pai.aniversariante"),
	NOIVA(3, "noiva"),
	MAE_NOIVA(4, "mae.noiva"),
	PAI_NOIVA(5, "pai.noiva"),
	NOIVO(6, "noivo"),
	MAE_NOIVO(7, "mae.noivo"),
	PAI_NOIVO(8, "pai.noivo");
	
	private Integer tipo;
	private String descricao;
	
	TipoClienteEvento(Integer tipo, String descricao){
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
	
	public static TipoClienteEvento valueOf(int i) {
		switch (i) {
			case 0: return ANIVERSARIANTE;
			case 1: return MAE_ANIVERSARIANTE;
			case 2: return PAI_ANIVERSARIANTE;
			case 3: return NOIVA;
			case 4: return MAE_NOIVA;
			case 5: return PAI_NOIVA;
			case 6: return NOIVO;
			case 7: return MAE_NOIVO;
			case 8: return MAE_NOIVO;
			default: return null;
		}
	}

	@Override
	public String toString() {
		return descricao;
	}
}
