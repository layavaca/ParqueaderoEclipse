package ec.edu.ups.parqueadero.Negocio;

import java.util.List;

import ec.edu.ups.parqueadero.Datos.TarifaDao;
import ec.edu.ups.parqueadero.Modelo.Tarifa;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
@Stateless
public class GestionTarifa {

	@Inject
	private TarifaDao daoTarifa;

	public void guardarTarifa(Tarifa tarifa) throws Exception {
		if (!this.isCedulaValida(tarifa.getCodigoTar()))
			throw new Exception("Tarifa incorrecta");
		if (daoTarifa.read(tarifa.getCodigoTar()) == null) {
			try {
				daoTarifa.insert(tarifa);

			} catch (Exception e) {
				throw new Exception("Error al insertar:" + e.getMessage());
				// TODO: handle exception
			}
		} else {
			try {
				daoTarifa.update(tarifa);
			} catch (Exception e) {
				throw new Exception("Error al actualizar:" + e.getMessage());
				// TODO: handle exception
			}
		}
	}
	
	public void eliminarTarifa(int codigoTar)  throws Exception {
		if (!this.isCedulaValida(codigoTar))
			throw new Exception("Tarifa incorrecta");
		if(daoTarifa.read(codigoTar)!= null) {
			try {
				daoTarifa.delete(codigoTar);
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

	public void guardarTarifa(String tipoCostoTar,
	int valorTar) {
	}

	public List<Tarifa> getTarifa() {
		return daoTarifa.getAll();
	}

}
