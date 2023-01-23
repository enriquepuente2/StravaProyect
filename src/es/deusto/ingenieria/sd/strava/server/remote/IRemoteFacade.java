package es.deusto.ingenieria.sd.strava.server.remote;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.SesionDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.TipoProveedor;
import es.deusto.ingenieria.sd.strava.server.data.dto.UsuarioDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public void signup(UsuarioDTO usuariodto) throws RemoteException;

	public List<String> getDeporte() throws RemoteException;

    public List<String> getDeporteRet() throws RemoteException;

    public List<String> getReto(long token) throws RemoteException;
    
    public List<String> getSesion(long token) throws RemoteException;

    public List<String> getRetoActivado(long token) throws RemoteException;

    public void makeSesion(SesionDTO dto, long token) throws RemoteException;

    public void makeReto(RetoDTO retodto, long token) throws RemoteException;

    public void activateReto(String nombre, long token) throws RemoteException;
    
    
//	public List<CategoryDTO> getCategories() throws RemoteException;
//	
//	public List<ArticleDTO> getArticles(String aCategory) throws RemoteException;
//	
//	public boolean makeBid(long token, int article, float amount) throws RemoteException;
//	
//	public float getUSDRate() throws RemoteException;
//	
//	public float getGBPRate() throws RemoteException;	
}
