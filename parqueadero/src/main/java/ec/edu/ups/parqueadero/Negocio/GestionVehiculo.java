package ec.edu.ups.parqueadero.Negocio;

import java.util.List;

import ec.edu.ups.parqueadero.Datos.VehiculoDao;
import ec.edu.ups.parqueadero.Modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionVehiculo {
	
	@Inject
	private VehiculoDao daoVehiculo;
	
	public void guardarVehiculos(Vehiculo vehiculo) throws Exception{
		if(!this.isPlacaValida(vehiculo.getPlacaVeh())) 
			throw new Exception("PLACA INCORRECTA");
		
		if (daoVehiculo.read(vehiculo.getPlacaVeh())==null) {
			try {
				daoVehiculo.insert(vehiculo);
			} catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}else {
			try {
				daoVehiculo.update(vehiculo);

			} catch (Exception e) {
				throw new Exception("Error al actualizar: "+ e.getMessage());
			}
		}
	}
	
	public void eliminarVehiculo(String placaVehi)  throws Exception {
		if (!this.isPlacaValida(placaVehi))
			throw new Exception("vehiculo incorrecta");
		if(daoVehiculo.read(placaVehi)!= null) {
			try {
				daoVehiculo.delete(placaVehi);
			} catch (Exception e) {
				throw new Exception("Error al eliminar:" + e.getMessage());
				// TODO: handle exception
			}
		}			
	}

	public boolean isPlacaValida(String placaVeh) {

		return placaVeh.length() == 10;
	}

	public void guardarVehiculos(String placaVeh, String marcaVeh, String colorVeh) {
	}

	public List<Vehiculo> getVehiculo() {
		return daoVehiculo.getAll();
	}

}
