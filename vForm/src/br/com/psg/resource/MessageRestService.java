package br.com.psg.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.core.Response;

import br.com.psg.controller.FormularioController;

@Path("/message")
public class MessageRestService {
	FormularioController controller = new FormularioController();

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}
	/*@Path("/getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg() {
		List<Formulario> listRetorno = controller.getForms();
		return Response.status(200).entity(listRetorno).build();
	}*/

}