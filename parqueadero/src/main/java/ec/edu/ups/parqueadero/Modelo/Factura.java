package ec.edu.ups.parqueadero.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Factura implements Serializable{
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoFac;
	private String nombreFac;
	private String direccionFac;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="per_cedula")
	private Persona persona;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Factura_id")
	private List<Ticket> ticket;
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
	
	public List<Ticket> getTicket() {
		return ticket;
	}
	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}
	
	
	public void addTicket(Ticket ticket) {
		if(this.ticket == null)
			this.ticket = new ArrayList<Ticket>();
		this.ticket.add(ticket);
	}
	@Override
	public String toString() {
		return "Factura [codigoFac=" + codigoFac + ", nombreFac=" + nombreFac + ", direccionFac=" + direccionFac
				+ ", persona=" + persona + ", ticket=" + ticket + "]";
	}
	
	
	
}
