package ec.edu.ups.parqueadero.Negocio;

import java.util.List;

import ec.edu.ups.parqueadero.Datos.EstacionamientoDao;
import ec.edu.ups.parqueadero.Modelo.Estacionamiento;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionEstacionamiento {
	@Inject
	private EstacionamientoDao daoEstacionamiento;

	public void guardarEstacionamiento(Estacionamiento estacionamiento) throws Exception {
		if (!this.isCedulaValida(estacionamiento.getCodigoEst()))
			throw new Exception("Estacionamiento incorrecta");
		if (daoEstacionamiento.read(estacionamiento.getCodigoEst()) == null) {
			try {
				daoEstacionamiento.insert(estacionamiento);

			} catch (Exception e) {
				throw new Exception("Error al insertar:" + e.getMessage());
				// TODO: handle exception
			}
		} else {
			try {
				daoEstacionamiento.update(estacionamiento);
			} catch (Exception e) {
				throw new Exception("Error al actualizar:" + e.getMessage());
				// TODO: handle exception
			}
		}
	}
	
	public void eliminarEstacionamiento(int codigoEst)  throws Exception {
		if (!this.isCedulaValida(codigoEst))
			throw new Exception("Estacionamiento incorrecta");
		if(daoEstacionamiento.read(codigoEst)!= null) {
			try {
				daoEstacionamiento.delete(codigoEst);
			} catch (Exception e) {
				throw new Exception("Error al eliminar:" + e.getMessage());
				// TODO: handle exception
			}
		}			
	}

	public boolean isCedulaValida(int cedula) {
		String cedula1 = Integer.toString(cedula);
		return cedula1.length() == 10;
	}

	public void eliminarEstacionamiento(Estacionamiento estacionamiento) {
		daoEstacionamiento.delete(estacionamiento.getCodigoEst());
	}

	public void guardarEstacionamiento(String tipoEst, int catidadEst) {

	}

	public List<Estacionamiento> getEstacionamiento() {
		return daoEstacionamiento.getAll();
	}

}
