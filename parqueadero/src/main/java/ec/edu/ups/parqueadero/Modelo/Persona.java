package ec.edu.ups.parqueadero.Modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Persona implements Serializable {
	@GeneratedValue
	private int codigoPer;
	@Id
	private int cedulaPer;
	private String nombrePer;
	private String apellidoPer;
	private String direccionPer;
	private String correoPer;
	private int telefonoPer;
	public int getCodigoPer() {
		return codigoPer;
	}
	public void setCodigoPer(int codigoPer) {
		this.codigoPer = codigoPer;
	}
	public int getCedulaPer() {
		return cedulaPer;
	}
	public void setCedulaPer(int cedulaPer) {
		this.cedulaPer = cedulaPer;
	}
	public String getNombrePer() {
		return nombrePer;
	}
	public void setNombrePer(String nombrePer) {
		this.nombrePer = nombrePer;
	}
	public String getApellidoPer() {
		return apellidoPer;
	}
	public void setApellidoPer(String apellidoPer) {
		this.apellidoPer = apellidoPer;
	}
	public String getDireccionPer() {
		return direccionPer;
	}
	public void setDireccionPer(String direccionPer) {
		this.direccionPer = direccionPer;
	}
	public String getCorreoPer() {
		return correoPer;
	}
	public void setCorreoPer(String correoPer) {
		this.correoPer = correoPer;
	}
	public int getTelefonoPer() {
		return telefonoPer;
	}
	public void setTelefonoPer(int telefonoPer) {
		this.telefonoPer = telefonoPer;
	}
	
	@Override
	public String toString() {
		return "Persona [codigoPer=" + codigoPer + ", cedulaPer=" + cedulaPer + ", nombrePer=" + nombrePer
				+ ", apellidoPer=" + apellidoPer + ", direccionPer=" + direccionPer + ", correoPer=" + correoPer
				+ ", telefonoPer=" + telefonoPer + "]";
	}
	
}
