package ec.edu.ups.parqueadero.Modelo;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket implements Serializable {
	@Id
	@GeneratedValue
	private int codigoTic;
	private Date fecha;
	private String horaEntrada;
	private String horaSalida;
	private String mensaje;
	private Vehiculo vehiculo;
	private Tarifa tarifa;
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
	public Tarifa getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	@Override
	public String toString() {
		return "Ticket [codigoTic=" + codigoTic + ", fecha=" + fecha + ", horaEntrada=" + horaEntrada + ", horaSalida="
				+ horaSalida + ", mensaje=" + mensaje + ", vehiculo=" + vehiculo + "]";
	}	
}
