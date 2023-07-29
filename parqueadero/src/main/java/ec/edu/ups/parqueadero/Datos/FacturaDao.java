package ec.edu.ups.parqueadero.Datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.parqueadero.Modelo.Factura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FacturaDao implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Factura factura) {
		em.persist(factura);
	}
	
	public void update(Factura factura) {
		em.merge(factura);
	}
	
	public Factura read(int codigoFac) {
		Factura p = em.find(Factura.class, codigoFac);
		return p;
	}
	
	public void delete(int codigoFac) {
		Factura p = em.find(Factura.class, codigoFac);
		em.remove(p);
	}
	
	public List<Factura> getAll(){
		String jpql = "SELECT p FROM Factura p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
