package ec.edu.ups.parqueadero.Modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vehiculo implements Serializable {
	
	@Id
	@GeneratedValue
	private int codigoVeh;
	private String placaVeh;
	private String marcaVeh;
	private String colorVeh;
	private Persona persona;
	
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
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [codigoVeh=" + codigoVeh + ", placaVeh=" + placaVeh + ", marcaVeh=" + marcaVeh + ", colorVeh="
				+ colorVeh + ", persona=" + persona + "]";
	}
}
