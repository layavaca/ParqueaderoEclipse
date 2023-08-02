package ec.edu.ups.parqueadero.Negocio;

import java.util.List;import javax.swing.CellEditor;

import ec.edu.ups.parqueadero.Datos.PersonaDao;
import ec.edu.ups.parqueadero.Modelo.Persona;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {

	@Inject
	private PersonaDao daoPersona;

	public void guardarCliente(Persona persona) throws Exception {
		if (!this.isCedulaValida(persona.getCedulaPer()))
			throw new Exception("cedula incorrecta");
		if (daoPersona.read(persona.getCedulaPer()) == null) {
			try {
				daoPersona.insert(persona);

			} catch (Exception e) {
				throw new Exception("Error al insertar:" + e.getMessage());
				// TODO: handle exception
			}
		} else {
			try {
				daoPersona.update(persona);
			} catch (Exception e) {
				throw new Exception("Error al actualizar:" + e.getMessage());
				// TODO: handle exception
			}
		}
	}

	public void eliminarCliente(String cedulaPer) throws Exception {
		if (!this.isCedulaValida(cedulaPer))
			throw new Exception("cedula incorrecta");
		if (daoPersona.read(cedulaPer) != null) {
			try {
				daoPersona.delete(cedulaPer);
			} catch (Exception e) {
				throw new Exception("Error al eliminar:" + e.getMessage());
				// TODO: handle exception
			}
		}
	}

	public boolean isCedulaValida(String cedula) {
		
		return cedula.length() == 10;
	}
	/*
	 * public void eliminarCliente(Persona persona) {
	 * daoPersona.delete(persona.getCedulaPer()); }
	 */

	public void guardarClientes(String cedulaPer, String nombrePer, String apellidoPer, String telefonoPer,
			String direccionPer) {
	}

	public List<Persona> getClientes() {
		return daoPersona.getAll();
		
	}
	public void listaCliente(String cedulaPer) throws Exception {
		if (!this.isCedulaValida(cedulaPer))
			throw new Exception("cedula incorrecta");
		if (daoPersona.read(cedulaPer) != null) {
			try {
				daoPersona.getAll();
				
			} catch (Exception e) {
				throw new Exception("Error al eliminar:" + e.getMessage());
				// TODO: handle exception
			}
		}
	}
}