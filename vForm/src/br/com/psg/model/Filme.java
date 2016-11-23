package br.com.psg.model;

public class Filme {
	private int numFilme;
	private String situacao;
	
	public int getNumFilme() {
		return numFilme;
	}
	public void setNumFilme(int numFilme) {
		this.numFilme = numFilme;
	}
	public String getSituacao(int nFilme) {
		switch (nFilme) {
		case 0:
			this.setSituacao("NORMAL");
			break;
		case 1:
			this.setSituacao("CANCELADO");
			break;
		default:
			this.setSituacao("INDEFINIDO");
			break;
		}
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	
}
