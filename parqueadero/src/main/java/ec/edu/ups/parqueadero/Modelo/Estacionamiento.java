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
public class Estacionamiento implements Serializable {
	@Id
	@GeneratedValue
	private int codigoEst;
	private String tipoEst;
	private int catidadEst;
	public int getCodigoEst() {
		return codigoEst;
	}
	public void setCodigoEst(int codigoEst) {
		this.codigoEst = codigoEst;
	}
	public String getTipoEst() {
		return tipoEst;
	}
	public void setTipoEst(String tipoEst) {
		this.tipoEst = tipoEst;
	}
	public int getCatidadEst() {
		return catidadEst;
	}
	public void setCatidadEst(int catidadEst) {
		this.catidadEst = catidadEst;
	}
	@Override
	public String toString() {
		return "Estacionamiento [codigoEst=" + codigoEst + ", tipoEst=" + tipoEst + ", catidadEst=" + catidadEst + "]";
	}

}
