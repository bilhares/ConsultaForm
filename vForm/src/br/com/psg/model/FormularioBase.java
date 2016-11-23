package br.com.psg.model;

import java.util.Date;

public class FormularioBase {
	long nLogico;
	String grafico;
	String situacao;
	String transmitido;
	String tipo;
	String tipoDescricao;
	long agenfa;
	String agenfaDescricao;
	Date data;
    long filme;
    long fotograma;
    String situacaoFilme;
    String observacao;
    int lote;
    String tipoLote;
    String situacaoLote;
    int posicao;
    String mensagem;
        
    
	public long getAgenfa() {
		return agenfa;
	}
	public void setAgenfa(long agenfa) {
		this.agenfa = agenfa;
	}
	public String getAgenfaDescricao() {
		return agenfaDescricao;
	}
	public void setAgenfaDescricao(String agenfaDescricao) {
		this.agenfaDescricao = agenfaDescricao;
	}
	public long getnLogico() {
		return nLogico;
	}
	public void setnLogico(long nLogico) {
		this.nLogico = nLogico;
	}
	public String getGrafico() {
		return grafico;
	}
	public void setGrafico(String grafico) {
		this.grafico = grafico;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getTransmitido() {
		return transmitido;
	}
	public void setTransmitido(String transmitido) {
		this.transmitido = transmitido;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipoDescricao() {
		return tipoDescricao;
	}
	public void setTipoDescricao(String tipoDescricao) {
		this.tipoDescricao = tipoDescricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public long getFilme() {
		return filme;
	}
	public void setFilme(long filme) {
		this.filme = filme;
	}
	public long getFotograma() {
		return fotograma;
	}
	public void setFotograma(long fotograma) {
		this.fotograma = fotograma;
	}
	public String getSituacaoFilme() {
		return situacaoFilme;
	}
	public void setSituacaoFilme(String situacaoFilme) {
		this.situacaoFilme = situacaoFilme;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public int getLote() {
		return lote;
	}
	public void setLote(int lote) {
		this.lote = lote;
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
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
