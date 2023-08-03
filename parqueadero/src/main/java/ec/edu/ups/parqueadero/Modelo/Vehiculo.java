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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Vehiculo {
	
	
	@Id
	@Column(name="vehiculo_id")
	private String placaVeh;
	private String marcaVeh;
	private String colorVeh;
	@ManyToOne(cascade = CascadeType.ALL)
    private Persona propietario;
	
	
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
	
	public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }
	@Override
	public String toString() {
		return "Vehiculo [ placaVeh=" + placaVeh + ", marcaVeh=" + marcaVeh + ", colorVeh="
				+ colorVeh + ", propietario=" + propietario + "]";
	}
    
	
	
}
