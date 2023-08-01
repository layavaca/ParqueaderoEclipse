package ec.edu.ups.parqueadero.Servicios;

import java.util.List;

import ec.edu.ups.parqueadero.Modelo.Tarifa;
import ec.edu.ups.parqueadero.Negocio.GestionTarifa;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class GTarifaService {
	@Inject
	private GestionTarifa gTarifa;

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarTarifa(Tarifa tarifa) {
		try {
			gTarifa.guardarTarifa(tarifa);
			return Response.status(Response.Status.OK).entity(tarifa).build();
		} catch (Exception e) {
			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:" + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}

	@DELETE
	@Path("id{codigoTar}")
	public Response eliminarEntidad(@PathParam("codigoTar") int codigoTar) {
		try {
			gTarifa.eliminarTarifa(codigoTar);
			return Response.status(Response.Status.OK).entity(codigoTar).build();
		} catch (Exception e) {
			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al eliminar:" + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}

	@GET
	@Path("lista1")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTarifa() {
		List<Tarifa> listado = gTarifa.getTarifa();
		return Response.status(Response.Status.OK).entity(listado).build();
	}


}
