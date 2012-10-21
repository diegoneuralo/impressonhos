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
	ACABAMENTO(0, "ACABAMENTO"),
	MATERIAL(1, "MATERIAL"),
	ACESSORIOS(2, "ACESSÓRIOS");
	
	private Integer tipo;
	private String descricao;
	
	TipoItemEvento(Integer tipo, String descricao){
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
	
	public static TipoItemEvento valueOf(int i) {
		switch (i) {
			case 0: return ACABAMENTO;
			case 1: return MATERIAL;
			case 2: return ACESSORIOS;
			default: return null;
		}
	}

	@Override
	public String toString() {
		return descricao;
	}
}
