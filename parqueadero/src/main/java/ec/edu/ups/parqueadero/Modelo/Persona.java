package ec.edu.ups.parqueadero.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Persona implements Serializable{
	@GeneratedValue
	private int codigoPer;
	@Id
	private String cedulaPer;
	private String nombrePer;
	private String apellidoPer;
	private String direccionPer;
	private String correoPer;
	private String telefonoPer;
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "PersonaF_id") 
	//private List<Factura> factura;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PersonaV_id") 
	private List<Vehiculo> vehiculo;
	
	
	public int getCodigoPer() {
		return codigoPer;
	}
	public void setCodigoPer(int codigoPer) {
		this.codigoPer = codigoPer;
	}
	public String getCedulaPer() {
		return cedulaPer;
	}
	public void setCedulaPer(String cedulaPer) {
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
	public String getTelefonoPer() {
		return telefonoPer;
	}
	public void setTelefonoPer(String telefonoPer) {
		this.telefonoPer = telefonoPer;
	}
	public List<Vehiculo> getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(List<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}
	public void addVehiculo(Vehiculo vehiculo) {
		if(this.vehiculo == null)
			this.vehiculo = new ArrayList<Vehiculo>();
		this.vehiculo.add(vehiculo);
	}
	@Override
	public String toString() {
		return "Persona [codigoPer=" + codigoPer + ", cedulaPer=" + cedulaPer + ", nombrePer=" + nombrePer
				+ ", apellidoPer=" + apellidoPer + ", direccionPer=" + direccionPer + ", correoPer=" + correoPer
				+ ", telefonoPer=" + telefonoPer + ", vehiculo=" + vehiculo + "]";
	}
	
}
