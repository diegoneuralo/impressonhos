package br.com.impressonhos.enums;

/**
 * Enum responsável pelos possíveis tipos do endereço. Opções.:
 * <ul>
 * 	<li>RECEPTIVO</li>
 * 	<li>CERIMONIAL</li>
 * 	<li>RESIDENCIAL</li>
 * 	<li>COMERCIAL</li>
 * </ul>
 * @author riccardof
 *
 */
public enum TipoEndereco {
	RECEPTIVO(0, "receptivo"),
	CERIMONIAL(1, "cerimonial"),
	RESIDENCIAL(2, "residencial"),
	COMERCIAL(3, "comercial");
	
	private Integer tipo;
	private String descricao;
	
	TipoEndereco(Integer tipo, String descricao){
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
	
	public static TipoEndereco valueOf(int i) {
		switch (i) {
			case 0: return RECEPTIVO;
			case 1: return CERIMONIAL;
			case 2: return RESIDENCIAL;
			case 3: return COMERCIAL;
			default: return null;
		}
	}

	@Override
	public String toString() {
		return descricao;
	}
}
