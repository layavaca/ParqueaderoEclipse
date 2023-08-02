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
	@Override
	public String toString() {
		return "Tarifa [codigoTar=" + codigoTar + ", tipoCostoTar=" + tipoCostoTar + ", valorTar=" + valorTar + "]";
	}
	
}