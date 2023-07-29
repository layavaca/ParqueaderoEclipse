package ec.edu.ups.parqueadero.Modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Estacionamiento implements Serializable {
	@Id
	@GeneratedValue
	private int codigoEst;
	private String tipoEst;
	private String lugarEst;
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
	public String getLugarEst() {
		return lugarEst;
	}
	public void setLugarEst(String lugarEst) {
		this.lugarEst = lugarEst;
	}
	@Override
	public String toString() {
		return "Estacionamiento [codigoEst=" + codigoEst + ", tipoEst=" + tipoEst + ", lugarEst=" + lugarEst + "]";
	}
	
}
