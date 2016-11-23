package br.com.psg.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.psg.dao.FormularioDao;
import br.com.psg.dao.FormularioDaoProducao;
import br.com.psg.model.Formulario;
import br.com.psg.model.FormularioBase;

public class FormularioController {
	List<FormularioBase> lista = new ArrayList<>();
	FormularioDao dao;
	FormularioDaoProducao daoProd;

	private List<Formulario> listaFormularios;

	public FormularioController() {
		this.dao = new FormularioDao();
		this.daoProd = new FormularioDaoProducao();
	}

	public List<FormularioBase> getForms() {
		Date data = new Date(System.currentTimeMillis());

		FormularioBase form = new FormularioBase();
		form.setnLogico(1012597433430L);
		form.setGrafico("A5754293");
		form.setSituacao("NORMAL");
		form.setTransmitido("1");
		form.setTipo("3");
		form.setTipoDescricao("AIDF");
		form.setAgenfa(90607805L);
		form.setAgenfaDescricao("TRES LAGOAS");
		form.setData(data);
		form.setFilme(544L);
		form.setFotograma(4135L);
		form.setSituacaoFilme("NORMAL");
		form.setObservacao("Observação");
		form.setLote(1);
		form.setTipoLote("NORMAL");
		form.setSituacaoLote("A CONFERIR");
		form.setPosicao(1);
		form.setMensagem("Mensagem");

		FormularioBase form2 = new FormularioBase();
		form2.setnLogico(1012597433430L);
		form2.setGrafico("A5754224");
		form2.setSituacao("NORMAL");
		form2.setTransmitido("2");
		form2.setTipo("5");
		form2.setTipoDescricao("AIDF");
		form2.setAgenfa(80509040);
		form2.setAgenfaDescricao("CAMPO GRANDE");
		form2.setData(data);
		form2.setFilme(544L);
		form2.setFotograma(4135L);
		form2.setSituacaoFilme("NORMAL");
		form2.setObservacao("Observação");
		form2.setLote(1);
		form2.setTipoLote("NORMAL");
		form2.setSituacaoLote("A CONFERIR");
		form2.setPosicao(1);
		form2.setMensagem("Mensagem");

		lista.add(form);
		lista.add(form2);
		return lista;
	}

	public List<Formulario> consultaGrafico(String grafico, String serie, int prod) {
		this.listaFormularios = new ArrayList<>();
		if (prod == 1) {
			this.listaFormularios = daoProd.buscaPorGrafico(grafico);
		} else {
			this.listaFormularios = dao.buscaPorGrafico(grafico, serie);
		}
		return this.listaFormularios;
	}

	public List<Formulario> consultarGraficoIntervalo(String graficoInicial, String graficoFinal, int prod) {
		
		this.listaFormularios = new ArrayList<>();
		if (prod == 1) {
			this.listaFormularios = daoProd.buscarIntervaloGrafico(graficoInicial, graficoFinal);
		} else {
			this.listaFormularios = dao.buscaIntervaloGrafico(graficoInicial, graficoFinal);
		}
		return this.listaFormularios;
	}
}
