package ec.edu.ups.parqueadero.Negocio;

import java.util.List;

import ec.edu.ups.parqueadero.Datos.VehiculoDao;
import ec.edu.ups.parqueadero.Modelo.Vehiculo;
import jakarta.inject.Inject;

public class GestionVehiculo {
	@Inject
	private VehiculoDao daoVehiculo;
	public void guardarCliente(Vehiculo vehiculo) throws Exception {
		if (!this.isPlacaValida(vehiculo.getPlacaVeh()))
			throw new Exception("cedula incorrecta");
		if (daoVehiculo.read(vehiculo.getPlacaVeh()) == null) {
			try {
				daoVehiculo.insert(vehiculo);

			} catch (Exception e) {
				throw new Exception("Error al insertar:" + e.getMessage());
				// TODO: handle exception
			}
		} else {
			try {
				daoVehiculo.update(vehiculo);
			} catch (Exception e) {
				throw new Exception("Error al actualizar:" + e.getMessage());
				// TODO: handle exception
			}
		}
	}

	public boolean isPlacaValida(String placaVeh) {
		 
		return placaVeh.length() == 10;
	}

	public void eliminarCliente(Vehiculo vehiculo) {
		daoVehiculo.delete(vehiculo.getPlacaVeh());					
	}

	public void guardarClientes(String placaVeh, String marcaVeh, String colorVeh) {
	}

	public List<Vehiculo> getClientes() {
		return daoVehiculo.getAll();
	}

}
