package ec.edu.ups.parqueadero.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Tarifa implements Serializable {
	@Id
	@GeneratedValue
	private int codigoTar;
	private String tipoCostoTar;
	private int valorTar;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name ="tarifa_id") 
	private List<Ticket> ticket;
	public int getCodigoTar() {
		return codigoTar;
	}
	public void setCodigoTar(int codigoTar) {
		this.codigoTar = codigoTar;
	}
	public String getTipoCostoTar() {
		return tipoCostoTar;
	}
	public void setTipoCostoTar(String tipoCostoTar) {
		this.tipoCostoTar = tipoCostoTar;
	}
	public int getValorTar() {
		return valorTar;
	}
	public void setValorTar(int valorTar) {
		this.valorTar = valorTar;
	}
	public List<Ticket> getTicket() {
		return ticket;
	}
	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "Tarifa [codigoTar=" + codigoTar + ", tipoCostoTar=" + tipoCostoTar + ", valorTar=" + valorTar
				+ ", ticket=" + ticket + "]";
	}
	public void addTicket(Ticket ticket) {
		if(this.ticket == null)
			this.ticket = new ArrayList<Ticket>();
		this.ticket.add(ticket);
	}
	

}
