package ec.edu.ups.parqueadero.Servicios;

import java.util.List;

import ec.edu.ups.parqueadero.Modelo.Vehiculo;
import ec.edu.ups.parqueadero.Negocio.GestionVehiculo;
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
@Path("vehiculo")
public class GVehiculoService {
	@Inject
	private GestionVehiculo gVehiculo;

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Vehiculo vehiculo) {
		try {
			gVehiculo.guardarVehiculo(vehiculo);
			return Response.status(Response.Status.OK).entity(vehiculo).build();
		} catch (Exception e) {
			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:" + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}

	@DELETE
	@Path("id{placaVeh}")
	public Response eliminarVehiculo(@PathParam("placaVeh") String placaVeh) {
		try {
			gVehiculo.eliminarVehiculo(placaVeh);
			return Response.status(Response.Status.OK).entity(placaVeh).build();
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
	public Response getVehiculo() {
		List<Vehiculo> listado = gVehiculo.getVehiculo();
		return Response.status(Response.Status.OK).entity(listado).build();
	}


}
