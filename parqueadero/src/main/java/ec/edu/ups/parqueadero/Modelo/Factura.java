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
import jakarta.persistence.ManyToOne;
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
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Persona propietarioCabecera;
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
	public Persona getPropietarioCabecera() {
		return propietarioCabecera;
	}
	public void setPropietarioCabecera(Persona propietarioCabecera) {
		this.propietarioCabecera = propietarioCabecera;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Factura [codigoFac=" + codigoFac + ", nombreFac=" + nombreFac + ", direccionFac=" + direccionFac
				+ ", propietarioCabecera=" + propietarioCabecera + "]";
	}
	
	

}