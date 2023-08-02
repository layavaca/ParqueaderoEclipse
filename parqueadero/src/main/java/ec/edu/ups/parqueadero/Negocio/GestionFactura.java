package ec.edu.ups.parqueadero.Negocio;

import java.util.List;

import ec.edu.ups.parqueadero.Datos.FacturaDao;
import ec.edu.ups.parqueadero.Modelo.Factura;
import ec.edu.ups.parqueadero.Modelo.Persona;
import ec.edu.ups.parqueadero.Modelo.Ticket;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionFactura {
	@Inject
	private FacturaDao daoFactura;

	public void guardarFactura(Factura factura) throws Exception {
		if (!this.isCedulaValida(factura.getCodigoFac()))
			throw new Exception("Factura incorrecta");
		if (daoFactura.read(factura.getCodigoFac()) == null) {
			try {
				daoFactura.insert(factura);

			} catch (Exception e) {
				throw new Exception("Error al insertar:" + e.getMessage());
				// TODO: handle exception
			}
		} else {
			try {
				daoFactura.update(factura);
			} catch (Exception e) {
				throw new Exception("Error al actualizar:" + e.getMessage());
				// TODO: handle exception
			}
		}
	}
	
	public void eliminarFactura(int codigoFac)  throws Exception {
		if (!this.isCedulaValida(codigoFac))
			throw new Exception("cedula incorrecta");
		if(daoFactura.read(codigoFac)!= null) {
			try {
				daoFactura.delete(codigoFac);
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

	public void guardarFactura(int codigoFac, String nombreFac, String direccionFac, Persona persona, Ticket ticket) {
	}

	public List<Factura> getFactura() {
		return daoFactura.getAll();
	}
}
