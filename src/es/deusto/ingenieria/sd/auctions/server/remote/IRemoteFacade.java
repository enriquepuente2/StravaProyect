package es.deusto.ingenieria.sd.auctions.server.remote;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

//import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
//import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public void signup(String nombre, String contr, String mail, String fNac, 
            double peso, int altura, double fCardiacaMaxima, double fCardiacaReposo, String log) throws RemoteException;

	public List<String> getDeporte() throws RemoteException;

    public String[] getDeporteRet() throws RemoteException;

    public List<String> getReto() throws RemoteException;

    public List<String> getRetoActivado() throws RemoteException;

    public void makeSesion(String titulo, String deporte, double km, String fInicio, 
            int hora, double duracion) throws RemoteException;

    public void makeReto(String nombre, String fInicio, String fFin, 
            double distancia, double objetivo, String deporte) throws RemoteException;

    public void activateReto(String nombre) throws RemoteException;
    
    
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
