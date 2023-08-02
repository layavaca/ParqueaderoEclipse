package ec.edu.ups.parqueadero.Servicios;

import java.util.List;


import ec.edu.ups.parqueadero.Datos.FacturaDao;
import ec.edu.ups.parqueadero.Modelo.Factura;
import ec.edu.ups.parqueadero.Negocio.GestionFactura;
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

@Path("factura")
public class GFacturaService  {
	@Inject
	private GestionFactura gFactura;
	@Inject
	private FacturaDao daoFactura;

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Factura factura) {
		try {
			gFactura.guardarFactura(factura);
			return Response.status(Response.Status.OK).entity(factura).build();
		} catch (Exception e) {
			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:" + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}

	@DELETE
	@Path("id{codigoFac}")
	public Response eliminarEntidad(@PathParam("codigoFac") int codigoFac) {
		try {
			gFactura.eliminarFactura(codigoFac);
			return Response.status(Response.Status.OK).entity(codigoFac).build();
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
	public Response getFactura() {
		List<Factura> listado = gFactura.getFactura();
		return Response.status(Response.Status.OK).entity(listado).build();
	}
	
	@GET
	@Path("lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Factura> getListadoFactura() {
		return daoFactura.getAll();

	}


}
