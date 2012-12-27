package br.com.impressonhos.enums;

/**
 * Enum responsável pelos possíveis tipos de papel. Opções:
 * <ul>
 * 	<li>ENVELOPE</li>
 * 	<li>INTERNO</li>
 *  <li>FORRO</li>
 * </ul>
 * @author riccardof
 *
 */
public enum UsoPapel {
	ENVELOPE(0, "envelope"),
	INTERNO(1, "interno"),
	FORRO(2, "forro");
	
	private Integer tipo;
	private String descricao;
	
	UsoPapel(Integer tipo, String descricao){
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
	
	public static UsoPapel valueOf(int i) {
		switch (i) {
			case 0: return ENVELOPE;
			case 1: return INTERNO;
			case 2: return FORRO;
			default: return null;
		}
	}

	@Override
	public String toString() {
		return descricao;
	}
}
