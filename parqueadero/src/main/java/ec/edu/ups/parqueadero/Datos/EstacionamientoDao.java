package ec.edu.ups.parqueadero.Datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.parqueadero.Modelo.Estacionamiento;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class EstacionamientoDao implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Estacionamiento estacionamiento) {
		em.persist(estacionamiento);
	}
	
	public void update(Estacionamiento estacionamiento) {
		em.merge(estacionamiento);
	}
	
	public Estacionamiento read(int codigoEst) {
		Estacionamiento p = em.find(Estacionamiento.class, codigoEst);
		return p;
	}
	
	public void delete(int codigoEst) {
		Estacionamiento p = em.find(Estacionamiento.class, codigoEst);
		em.remove(p);
	}
	
	public List<Estacionamiento> getAll(){
		String jpql = "SELECT p FROM Estacionamiento p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}

}
