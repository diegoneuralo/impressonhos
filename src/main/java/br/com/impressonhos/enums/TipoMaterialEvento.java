package br.com.impressonhos.enums;

/**
 * Enum que define o tipo do material no evento - se o mesmo é referente a um agregado,
 * como por exemplo guardanapos ou canecas personalizadas, ou ao convite do evento. Opções:
 * <ul>
 * 	<li>AGREGADO</li>
 * 	<li>CONVITE</li>
 * </ul>
 * @author riccardof
 *
 */
public enum TipoMaterialEvento {
	AGREGADO(0, "AGREGADO"),
	CONVITE(1, "CONVITE");
	
	private Integer tipo;
	private String descricao;
	
	TipoMaterialEvento(Integer tipo, String descricao){
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
	
	public static TipoMaterialEvento valueOf(int i) {
		switch (i) {
			case 0: return AGREGADO;
			case 1: return CONVITE;
			default: return null;
		}
	}

	@Override
	public String toString() {
		return descricao;
	}
}
