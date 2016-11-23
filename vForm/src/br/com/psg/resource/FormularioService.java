package br.com.psg.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.psg.controller.FormularioController;
import br.com.psg.model.Formulario;
import br.com.psg.model.FormularioBase;
import br.com.psg.model.RequestBody;

/**
 * Classe contendo as pesquisas basicas sem criterio, em produção ou não
 * 
 * @author fsalles
 *
 */
@Path("/formulario")
public class FormularioService {
	FormularioController controller;

	public FormularioService() {
		controller = new FormularioController();
	}

	@Path("/getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg() {
		List<FormularioBase> listRetorno = controller.getForms();
		return Response.status(200).entity(listRetorno).build();
	}

	/**
	 * Pesquisa por grafico, consome json com grafico, serie, e verifica se é
	 * produção
	 * 
	 * @param request
	 * @return
	 */
	@Path("/byGrafico")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByGrafico(RequestBody request) {
		String numGrafico = request.grafico;
		String serie = request.serie;
		int prod = request.isProducao;
		List<Formulario> listRetorno = controller.consultaGrafico(numGrafico, serie, prod);
		return Response.status(200).entity(listRetorno).build();
	}

	/**
	 * Pesquisa por intervalo grafico, consome json com grafico de e até, serie,
	 * e verifica se é produção
	 * 
	 * @param request
	 * @return
	 */
	@Path("/byIntervaloGrafico")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByIntervaloGrafico(RequestBody request) {
		String graficoInicial = request.graficoInicial;
		String graficoFinal = request.graficoFinal;
		int prod = request.isProducao;
		List<Formulario> listRetorno = controller.consultarGraficoIntervalo(graficoInicial, graficoFinal, prod);
		return Response.status(200).entity(listRetorno).build();
	}
}
