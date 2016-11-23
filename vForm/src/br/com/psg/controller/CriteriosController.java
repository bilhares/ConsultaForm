package br.com.psg.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.psg.dao.FormularioCriteriosDao;
import br.com.psg.dao.FormularioCriteriosDaoProducao;
import br.com.psg.model.Formulario;

public class CriteriosController {
	private List<Formulario> listaFormularios;
	private FormularioCriteriosDao dao;
	private FormularioCriteriosDaoProducao daoProd;

	public CriteriosController() {
		this.dao = new FormularioCriteriosDao();
		this.daoProd = new FormularioCriteriosDaoProducao();
	}

	public List<Formulario> consultaIntervaloGraficoData(String graficoInicial, String graficoFinal, int prod,
			String dataInicial, String dataFinal) throws SQLException {
		listaFormularios = new ArrayList<>();
		if (prod == 1) {
			listaFormularios = this.daoProd.buscaIntervaloGraficoData(graficoInicial, graficoFinal, dataInicial, dataFinal);
		} else {
			listaFormularios = this.dao.buscaIntervaloGraficoData(graficoInicial, graficoFinal, dataInicial, dataFinal);
		}
		return listaFormularios;
	}
}
