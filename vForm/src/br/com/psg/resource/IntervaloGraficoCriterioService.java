package br.com.psg.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.psg.controller.CriteriosController;
import br.com.psg.model.Formulario;
import br.com.psg.model.RequestBody;

@Path("/intervaloGCriterio")
public class IntervaloGraficoCriterioService {
	private CriteriosController controller;

	public IntervaloGraficoCriterioService() {
		controller = new CriteriosController();
	}

	@Path("/byIntervaloGraficoData")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByIntervaloGraficoData(RequestBody request) throws SQLException {
		List<Formulario> listRetorno = this.controller.consultaIntervaloGraficoData(request.graficoInicial,
				request.graficoFinal, request.isProducao, request.dataInicial, request.dataFinal);
		return Response.status(200).entity(listRetorno).build();
	}
}
