package ec.edu.ups.parqueadero.Datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.parqueadero.Modelo.Tarifa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class TarifaDao implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Tarifa tarifa) {
		em.persist(tarifa);
	}
	
	public void update(Tarifa tarifa) {
		em.merge(tarifa);
	}
	
	public Tarifa read(int codigoTar) {
		Tarifa p = em.find(Tarifa.class, codigoTar);
		return p;
	}
	
	public void delete(int codigoTar) {
		Tarifa p = em.find(Tarifa.class, codigoTar);
		em.remove(p);
	}
	
	public List<Tarifa> getAll(){
		String jpql = "SELECT p FROM Tarifa p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
