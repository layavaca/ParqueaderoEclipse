package ec.edu.ups.parqueadero.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Vehiculo {
	
	
	@GeneratedValue
	private int codigoVeh;
	@Id
	@Column(name="vehiculo_id")
	private String placaVeh;
	private String marcaVeh;
	private String colorVeh;
	@OneToMany(mappedBy = "vehiculo",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Ticket> ticket;
	
	public int getCodigoVeh() {
		return codigoVeh;
	}
	public void setCodigoVeh(int codigoVeh) {
		this.codigoVeh = codigoVeh;
	}
	public String getPlacaVeh() {
		return placaVeh;
	}
	public void setPlacaVeh(String placaVeh) {
		this.placaVeh = placaVeh;
	}
	public String getMarcaVeh() {
		return marcaVeh;
	}
	public void setMarcaVeh(String marcaVeh) {
		this.marcaVeh = marcaVeh;
	}
	public String getColorVeh() {
		return colorVeh;
	}
	public void setColorVeh(String colorVeh) {
		this.colorVeh = colorVeh;
	}/*
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}*/
	public List<Ticket> getTicket() {
		return ticket;
	}
	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "Vehiculo [codigoVeh=" + codigoVeh + ", placaVeh=" + placaVeh + ", marcaVeh=" + marcaVeh + ", colorVeh="
				+ colorVeh + "	, ticket=" + ticket + "]";
	}
	public void addTicket(Ticket ticket) {
		if(this.ticket == null)
			this.ticket = new ArrayList<Ticket>();
		this.ticket.add(ticket);
	}
	
}
