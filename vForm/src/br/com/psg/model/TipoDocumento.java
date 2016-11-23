package br.com.psg.model;

public class TipoDocumento {
	private int tipo;
	private String descricao;

	public String getDescricao(int codTipo) {
		switch (codTipo) {
		case 1:
			this.setDescricao("NOTA FISCAL");
			break;
		case 2:
			this.setDescricao("DAEMS 27");
			break;
		case 3:
			this.setDescricao("AIDF");
			break;
		case 4:
			this.setDescricao("DAEMS 19");
			break;
		default:
			this.setDescricao("INDEFINIDO");
			break;
		}
		return descricao;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}		
	
	public int getTipo() {
		return tipo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static void main(String[] args) {
		TipoDocumento t = new TipoDocumento();
		t.setTipo(1);
		String doc = t.getDescricao(t.getTipo());
		System.out.println("" + doc);
	}

}
