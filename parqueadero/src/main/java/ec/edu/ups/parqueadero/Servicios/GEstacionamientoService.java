package ec.edu.ups.parqueadero.Servicios;

import java.util.List;

import ec.edu.ups.parqueadero.Modelo.Estacionamiento;
import ec.edu.ups.parqueadero.Negocio.GestionEstacionamiento;
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

public class GEstacionamientoService {
	@Inject
	private GestionEstacionamiento gEstacionamiento;

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Estacionamiento estacionamiento) {
		try {
			gEstacionamiento.guardarEstacionamiento(estacionamiento);
			return Response.status(Response.Status.OK).entity(estacionamiento).build();
		} catch (Exception e) {
			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:" + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}

	@DELETE
	@Path("id{codigoEst}")
	public Response eliminarEntidad(@PathParam("codigoEst") int codigoEst) {
		try {
			gEstacionamiento.eliminarEstacionamiento(codigoEst);
			return Response.status(Response.Status.OK).entity(codigoEst).build();
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
	public Response getEstacionamiento() {
		List<Estacionamiento> listado = gEstacionamiento.getEstacionamiento();
		return Response.status(Response.Status.OK).entity(listado).build();
	}


}
