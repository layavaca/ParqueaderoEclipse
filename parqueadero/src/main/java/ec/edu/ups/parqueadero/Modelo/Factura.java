package ec.edu.ups.parqueadero.Modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Factura implements Serializable {
	@Id
	@GeneratedValue
	private int codigoFac;
	private String nombreFac;
	private String direccionFac;
	private Persona persona;
	private Ticket ticket;
	public int getCodigoFac() {
		return codigoFac;
	}
	public void setCodigoFac(int codigoFac) {
		this.codigoFac = codigoFac;
	}
	public String getNombreFac() {
		return nombreFac;
	}
	public void setNombreFac(String nombreFac) {
		this.nombreFac = nombreFac;
	}
	public String getDireccionFac() {
		return direccionFac;
	}
	public void setDireccionFac(String direccionFac) {
		this.direccionFac = direccionFac;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "Factura [codigoFac=" + codigoFac + ", nombreFac=" + nombreFac + ", direccionFac=" + direccionFac
				+ ", persona=" + persona + ", ticket=" + ticket + "]";
	}
	
}
