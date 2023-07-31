package ec.edu.ups.parqueadero.Negocio;

import java.util.List;

import ec.edu.ups.parqueadero.Datos.FacturaDao;
import ec.edu.ups.parqueadero.Modelo.Factura;
import jakarta.inject.Inject;

public class GestionFactura {
	@Inject
	private FacturaDao daoFactura;

	public void guardarCliente(Factura factura) throws Exception {
		if (!this.isCedulaValida(factura.getCodigoFac()))
			throw new Exception("cedula incorrecta");
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

	public boolean isCedulaValida(int cedula) {
		 String cedula1 = Integer.toString(cedula); 
		return cedula1.length() == 10;
	}

	public void eliminarCliente(Factura factura) {
		daoFactura.delete(factura.getCodigoFac());					
	}

	public void guardarClientes(String cedulaPer, String nombrePer, String direccionPer) {
	}

	public List<Factura> getClientes() {
		return daoFactura.getAll();
	}

}
