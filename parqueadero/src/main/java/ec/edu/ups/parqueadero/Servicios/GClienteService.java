package ec.edu.ups.parqueadero.Servicios;

import java.util.List;

import ec.edu.ups.parqueadero.Datos.PersonaDao;
import ec.edu.ups.parqueadero.Modelo.Persona;
import ec.edu.ups.parqueadero.Negocio.GestionClientes;
import jakarta.ejb.Stateless;
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

@Path("cliente")
public class GClienteService {
	@Inject
	private GestionClientes gClientes;
	@Inject
	private PersonaDao personaDao; 

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Persona persona) {
		try {
			gClientes.guardarCliente(persona);
			return Response.status(Response.Status.OK).entity(persona).build();
		} catch (Exception e) {
			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:" + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}

	@DELETE
	@Path("id{cedulaPer}")
	public Response eliminarEntidad(@PathParam("cedulaPer") String cedulaPer) {
		try {
			gClientes.eliminarCliente(cedulaPer);
			return Response.status(Response.Status.OK).entity(cedulaPer).build();
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
	public Response getPersona() {
		List<Persona> listado = gClientes.getClientes();
		return Response.status(Response.Status.OK).entity(listado).build();
	}

}
