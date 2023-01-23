package es.deusto.ingenieria.sd.strava.dao;

import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;


public interface IStravaDAO {

	public void storeUsuario(Usuario usuario);
	public Usuario getUsuario(String name);
	public void updateUsuario(Usuario usuario);
	
	public List<Reto> getRetos();
	public List<Sesion> getSesiones();
	public List<Reto> getRetosActivos();

	public void deleteAllUsuarios();

}
