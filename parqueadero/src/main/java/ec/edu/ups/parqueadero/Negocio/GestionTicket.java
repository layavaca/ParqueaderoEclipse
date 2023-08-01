package ec.edu.ups.parqueadero.Negocio;

import java.util.Date;
import java.util.List;

import ec.edu.ups.parqueadero.Datos.TicketDao;
import ec.edu.ups.parqueadero.Modelo.Ticket;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionTicket {
	
	@Inject
	private TicketDao daoTicket;

	public void guardarTicket(Ticket ticket) throws Exception {
		if (!this.isCedulaValida(ticket.getCodigoTic()))
			throw new Exception("Ticket incorrecta");
		if (daoTicket.read(ticket.getCodigoTic()) == null) {
			try {
				daoTicket.insert(ticket);

			} catch (Exception e) {
				throw new Exception("Error al insertar:" + e.getMessage());
				// TODO: handle exception
			}
		} else {
			try {
				daoTicket.update(ticket);
			} catch (Exception e) {
				throw new Exception("Error al actualizar:" + e.getMessage());
				// TODO: handle exception
			}
		}
	}
	
	public void eliminarTicket(int codigoTic)  throws Exception {
		if (!this.isCedulaValida(codigoTic))
			throw new Exception("Ticket incorrecta");
		if(daoTicket.read(codigoTic)!= null) {
			try {
				daoTicket.delete(codigoTic);
			} catch (Exception e) {
				throw new Exception("Error al eliminar:" + e.getMessage());
				// TODO: handle exception
			}
		}			
	}

	public boolean isCedulaValida(int codigo) {
		 String cedula1 = Integer.toString(codigo); 
		return cedula1.length() == 10;
	}

	public void guardarTicket(Date fecha,
	 String horaEntrada,
	 String horaSalida,
	 String mensaje) {
	}

	public List<Ticket> getTicket() {
		return daoTicket.getAll();
	}

}
