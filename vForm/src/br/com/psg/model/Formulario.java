package br.com.psg.model;


import java.sql.Date;

import javafx.scene.chart.PieChart.Data;

public class Formulario {
	private Long imagem;
	private int localImagem;
	private String grafico;
	private String situacao;
	private String nLogico;
	private String data;
	private int fotograma;
	private String obs;
	private String semTransmissao;


	// campos estrangeiros
	private int codTipo;
	private String tipoDocumento;
	private int filme;
	private String situacaoFilme;
	private String numAgenfa;
	private String descricaoAgenfa;
	private String numLote;
	private String tipoLote;
	private String situacaoLote;
	
	//Producao
	private String posicao;
	private String mensagem;
	
	//public TipoDocumento tipoDocumento;
	//public Agenfa agenfa;
	//public Filme filme;
	//public Lote lote;

	public Formulario() {
		//this.tipoDocumento = new TipoDocumento();
		//this.agenfa = new Agenfa();
		//this.filme = new Filme();
		//this.lote = new Lote();
	}

	public String getSemTransmissao() {
		return semTransmissao;
	}

	public void setSemTransmissao(String semTransmissao) {
		this.semTransmissao = semTransmissao;
	}



	public String getGrafico() {
		return grafico;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void setGrafico(String grafico) {
		this.grafico = grafico;
	}
			
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}	

	public int getCodTipo() {
		return codTipo;
	}

	public void setCodTipo(int codTipo) {
		this.codTipo = codTipo;
	}	
	
	public String getnLogico() {
		return nLogico;
	}

	public void setnLogico(String nLogico) {
		this.nLogico = nLogico;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getFotograma() {
		return fotograma;
	}

	public void setFotograma(int fotograma) {
		this.fotograma = fotograma;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public int getFilme() {
		return filme;
	}

	public void setFilme(int filme) {
		this.filme = filme;
	}

	public String getSituacaoFilme() {
		return situacaoFilme;
	}

	public void setSituacaoFilme(String situacaoFilme) {
		this.situacaoFilme = situacaoFilme;
	}	
	
	public String getNumAgenfa() {
		return numAgenfa;
	}

	public void setNumAgenfa(String numAgenfa) {
		this.numAgenfa = numAgenfa;
	}

	public String getDescricaoAgenfa() {
		return descricaoAgenfa;
	}

	public void setDescricaoAgenfa(String descricaoAgenfa) {
		this.descricaoAgenfa = descricaoAgenfa;
	}
	
	
	public String getNumLote() {
		return numLote;
	}

	public void setNumLote(String numLote) {
		this.numLote = numLote;
	}

	public String getTipoLote() {
		return tipoLote;
	}

	public void setTipoLote(String tipoLote) {
		this.tipoLote = tipoLote;
	}

	public String getSituacaoLote() {
		return situacaoLote;
	}

	public void setSituacaoLote(String situacaoLote) {
		this.situacaoLote = situacaoLote;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String obterSituacao(int codSit){
		String situacao;
		switch (codSit) {
		case 0:
			situacao = "NORMAL";
			break;
		case 1:
			situacao = "CANCELADO";
			break;
		default:
			situacao = "INDEFINIDO";
			break;
		}	
		return situacao;
	}
	public String obterTransmissao(int codTransmissao){
		String transmissao;
		switch (codTransmissao) {
		case 0:
			transmissao = "SIM";
			break;
		case 1:
			transmissao = "NÃO";
			break;
		default:
			transmissao = "INDEFINIDO";
			break;
		}
		return transmissao;
	}
	public String obterPosicao(int codPosicao){
		String posicao;
		switch (codPosicao) {
		case 0:
			posicao = "EM CONFERÊNCIA";
			break;
		case 1:
			posicao = "TRANSMITIDO";
			break;
		case 2:
			posicao = "REJEITADO MAINFRAME";
			break;
		case 3:
			posicao = "AGUARDANDO DISPONIBILIZAÇÃO";
			break;
		case 4:
			posicao = "EXCLUIDA";
			break;
		case 5:
			posicao = "REPRESADA AGUARDANDO SOLUÇÃO";
			break;
		case 6:
			posicao = "PARA SER DISPONIBILIZADO";
			break;
		case 7:
			posicao = "ERRO DE DISP./REALOC.";
			break;
		case 8:
			posicao = "REPETIDO(ODS)";
			break;
		case 9:
			posicao = "PARA SER REALOCADO";
			break;
		case 10:
			posicao = "NÃO TRANSMITIR";
			break;
		case 11:
			posicao = "ACEITO MAINFRAME. DISPONÍVEL EM CONSULTA";
			break;
		default:
			posicao = "INDEFINIDO";
			break;
		}
	return posicao;
	}
}
