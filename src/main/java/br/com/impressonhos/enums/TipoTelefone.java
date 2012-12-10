package br.com.impressonhos.enums;

/**
 * Enum responsável pelos tipos de telefone. Opções:
 * 	<li>RESIDENCIAL</li>
 * 	<li>CELULAR</li>
 * 	<li>COMERCIAL</li>
 * 	<li>RECADOS</li>
 * </ul>
 * @author riccardof
 *
 */
public enum TipoTelefone {
	RESIDENCIAL(0, "residencial"),
	CELULAR(1, "celular"),
	COMERCIAL(2, "comercial"),
	RECADOS(2, "recados");
	
	private Integer tipo;
	private String descricao;
	
	TipoTelefone(Integer tipo, String descricao){
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
	
	public static TipoTelefone valueOf(int i) {
		switch (i) {
			case 0: return RESIDENCIAL;
			case 1: return CELULAR;
			case 2: return COMERCIAL;
			case 3: return RECADOS;
			default: return null;
		}
	}

	@Override
	public String toString() {
		return descricao;
	}
}
