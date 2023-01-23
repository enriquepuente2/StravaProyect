package es.deusto.ingenieria.sd.strava.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class StravaDAO implements IStravaDAO{
	
	private PersistenceManagerFactory pmf;

	public StravaDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	@Override
	public void storeUsuario(Usuario usuario) {
	PersistenceManager pm = pmf.getPersistenceManager();
	Transaction tx = pm.currentTransaction();

	try {
		tx.begin();
		System.out.println("   * Storing an usuario: " + usuario);
		pm.makePersistent(usuario);
		tx.commit();
	} catch (Exception ex) {
		System.out.println("   $ Error storing an usuario: " + ex.getMessage());
	} finally {
		if (tx != null && tx.isActive()) {
			tx.rollback();
		}

		pm.close();
	}
		
	}

	@Override
	public Usuario getUsuario(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reto> getRetos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sesion> getSesiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reto> getRetosActivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllUsuarios() {
		// TODO Auto-generated method stub
		
	}

}
