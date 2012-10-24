package br.com.impressonhos.enums;

/**
 * Enum responsável pelos possíveis tipos de pessoa. Opções:
 * <ul>
 * 	<li>FISICA</li>
 * 	<li>JURIDICA</li>
 * </ul>
 * @author riccardof
 *
 */
public enum TipoPessoa {
	FISICA(0, "FÍSICA"),
	JURIDICA(1, "JURÍDICA");
	
	private Integer tipo;
	private String descricao;
	
	TipoPessoa(Integer tipo, String descricao){
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
	
	public static TipoPessoa valueOf(int i) {
		switch (i) {
			case 0: return FISICA;
			case 1: return JURIDICA;
			default: return null;
		}
	}

	@Override
	public String toString() {
		return descricao;
	}
}
