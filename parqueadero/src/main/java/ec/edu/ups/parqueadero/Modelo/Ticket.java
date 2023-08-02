package ec.edu.ups.parqueadero.Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Ticket implements Serializable {
	@Id
	@GeneratedValue
	private int codigoTic;
	private Date fecha;
	private String horaEntrada;
	private String horaSalida;
	private String mensaje;
	@ManyToOne
	@JoinColumn(name="Vehiculo_id")
	private Vehiculo vehiculo;
	//private Tarifa tarifa;
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "Ticket_id") 
	//private List<Factura>factura;
	public int getCodigoTic() {
		return codigoTic;
	}
	public void setCodigoTic(int codigoTic) {
		this.codigoTic = codigoTic;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	/*public Tarifa getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}*/
	/*public List<Factura> getFactura() {
		return factura;
	}
	public void setFactura(List<Factura> factura) {
		this.factura = factura;
	}*/
	@Override
	public String toString() {
		return "Ticket [codigoTic=" + codigoTic + ", fecha=" + fecha + ", horaEntrada=" + horaEntrada + ", horaSalida="
				+ horaSalida + ", mensaje=" + mensaje + ", vehiculo=" + vehiculo + "]";
	}
	
		
}
