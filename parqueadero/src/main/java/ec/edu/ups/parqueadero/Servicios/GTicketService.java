package ec.edu.ups.parqueadero.Servicios;

import java.util.List;

import ec.edu.ups.parqueadero.Modelo.Ticket;
import ec.edu.ups.parqueadero.Negocio.GestionTicket;
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
@Path("ticket")
public class GTicketService {
	@Inject
	private GestionTicket gTicket;

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarTicket(Ticket ticket) {
		try {
			gTicket.guardarTicket(ticket);
			return Response.status(Response.Status.OK).entity(ticket).build();
		} catch (Exception e) {
			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:" + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}

	@DELETE
	@Path("id{codigoTic}")
	public Response eliminarTicket(@PathParam("codigoTic") int codigoTic) {
		try {
			gTicket.eliminarTicket(codigoTic);
			return Response.status(Response.Status.OK).entity(codigoTic).build();
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
	public Response getTicket() {
		List<Ticket> listado = gTicket.getTicket();
		return Response.status(Response.Status.OK).entity(listado).build();
	}


}
