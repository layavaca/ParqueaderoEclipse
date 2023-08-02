package ec.edu.ups.parqueadero.Negocio;


import java.sql.Timestamp;
import java.util.List;

import ec.edu.ups.parqueadero.Datos.EstacionamientoDao;
import ec.edu.ups.parqueadero.Datos.FacturaDao;
import ec.edu.ups.parqueadero.Datos.PersonaDao;
import ec.edu.ups.parqueadero.Datos.TarifaDao;
import ec.edu.ups.parqueadero.Datos.TicketDao;
import ec.edu.ups.parqueadero.Datos.VehiculoDao;
import ec.edu.ups.parqueadero.Modelo.Estacionamiento;
import ec.edu.ups.parqueadero.Modelo.Factura;
import ec.edu.ups.parqueadero.Modelo.Persona;
import ec.edu.ups.parqueadero.Modelo.Tarifa;
import ec.edu.ups.parqueadero.Modelo.Ticket;
import ec.edu.ups.parqueadero.Modelo.Vehiculo;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class dempPrueba {
	@Inject
	private PersonaDao daoPersona;
	@Inject
	private VehiculoDao daoVehiculo;
	@Inject
	private EstacionamientoDao daoEstacionamiento;
	@Inject
	private TarifaDao daoTarifa;
	@Inject
	private TicketDao daoTicket;
	@Inject
	private FacturaDao daoFactura;
	@PostConstruct
	public void init() {
		 
		System.out.println("Hola UPS");
		
		Vehiculo veh = new Vehiculo();
		veh.setPlacaVeh("ABC0102");
		veh.setMarcaVeh("Toyota");
		veh.setColorVeh("Rojo");
		daoVehiculo.insert(veh);
		
		Persona p1 = new Persona();
		p1.setCedulaPer("0107083511");
		p1.setDireccionPer("san joaquin");
		p1.setNombrePer("noe");
		p1.setApellidoPer("ayavaca");
		p1.setCorreoPer("nayavaca@est.ups.edu.ec");
		p1.setTelefonoPer("0988774158");		
		
		p1.addVehiculo(veh);
		
		daoPersona.insert(p1);
		
		Ticket tic = new Ticket();
		tic.setFecha(new Timestamp(System.currentTimeMillis()));
		tic.setHoraEntrada("17:00");
		tic.setHoraSalida("19:00");
		tic.setMensaje("No votar");
		tic.setVehiculo(veh);
		
		daoTicket.insert(tic);
		
		Estacionamiento est= new Estacionamiento();
		est.setCatidadEst(10);
		est.setTipoEst("privado");
		est.addTicket(tic);
		
		daoEstacionamiento.insert(est);
		
		Tarifa tar = new Tarifa();
		tar.setValorTar(25);
		tar.setTipoCostoTar("normal");
		tar.addTicket(tic);
		
		daoTarifa.insert(tar);
		
		Factura fac = new Factura();
		fac.setNombreFac("Topsy");
		fac.setDireccionFac("Americas");
		fac.setPersona(p1);
		fac.addTicket(tic);
		
		daoFactura.insert(fac);
		
		System.out.println("Hola Factura");
		
		List<Factura> facturas = daoFactura.getAll();
		for(Factura facq: facturas) {
			System.out.println(facq);
		
	}
	}
}
