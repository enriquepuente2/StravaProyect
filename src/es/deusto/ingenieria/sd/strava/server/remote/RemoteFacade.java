package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.dao.StravaDAO;
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.SesionAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.SesionDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.TipoProveedor;
import es.deusto.ingenieria.sd.strava.server.data.dto.UsuarioDTO;
import es.deusto.ingenieria.sd.strava.server.service.LoginAppService;
import es.deusto.ingenieria.sd.strava.server.service.RetoAppService;
import es.deusto.ingenieria.sd.strava.server.service.SesionAppService;


public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = LoginAppService.getInstance();
	private RetoAppService retoService = RetoAppService.getInstance();
	private SesionAppService sesionService = SesionAppService.getInstance();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public synchronized long login(String email, String contrasenia) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + contrasenia);
				
		//Perform login() using LoginAppService
		Usuario usuario = loginService.login(email, contrasenia);
			
		//If login() success user is stored in the Server State
		if (usuario != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(usuario)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, usuario);		
				return(token);
			} else {
				throw new RemoteException("Usuario ya esta logeado!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	@Override
	public synchronized void signup(UsuarioDTO usuariodto) throws RemoteException{
		System.out.println(" * RemoteFacade signup(): " + usuariodto.getNombre() + " / " + usuariodto.getContr());
		
		Usuario usuario;
		if(usuariodto.getTipoProveedor() == null) {
			usuario = new Usuario(usuariodto.getNombre(), usuariodto.getContr(), usuariodto.getMail(), usuariodto.getfNac(), usuariodto.getPeso(), usuariodto.getAltura(), usuariodto.getfCardiacaMaxima(), usuariodto.getfCardiacaReposo(), usuariodto.getLog(),usuariodto.getTipoProveedor());
		} else {
			usuario = new Usuario(usuariodto.getNombre(), usuariodto.getContr(), usuariodto.getMail(), usuariodto.getfNac(), usuariodto.getPeso(), usuariodto.getAltura(), usuariodto.getfCardiacaMaxima(), usuariodto.getfCardiacaReposo(), usuariodto.getLog(),usuariodto.getTipoProveedor());
		}
		
		if (!loginService.signup(usuario)) {
			throw new RemoteException("El usuario ya esta registrado! Registrate con otro usuario");
		}
	}
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);			
		if (this.serverState.containsKey(token)) {
			this.serverState.remove(token);
		} else {
			throw new RemoteException("El usuario no esta logeado!");
		}
	}
	
	@Override
    public List<String> getDeporte() throws RemoteException {
        return SesionDTO.getTipoDeporte();
    }

    @Override
    public List<String> getDeporteRet() throws RemoteException {
        return RetoDTO.getTipoDeporte();
    }

    @Override
    public List<String> getSesion(long token) throws RemoteException {
        List<String> sesiones = new ArrayList<>();
        for(Sesion r: StravaDAO.getInstance().getSesiones(serverState.get(token))) {
			sesiones.add(SesionAssembler.sesionToDTO(r).toString());
		}
        return sesiones;
    }
    
    @Override
    public List<String> getReto(long token) throws RemoteException {
        List<String> retos = new ArrayList<>();
        for(Reto r: StravaDAO.getInstance().getRetos(serverState.get(token))) {
			retos.add(RetoAssembler.retoToDTO(r).toString());
		}
        return retos;
    }

    @Override
    public List<String> getRetoActivado(long token) throws RemoteException {
        List<String> retos = new ArrayList<>();
        for(Reto r: StravaDAO.getInstance().getRetosActivos(serverState.get(token))) {
			retos.add(RetoAssembler.retoToDTO(r).toString());
		}
        return retos;
    }

    @Override
    public void activateReto(String nombre, long token) throws RemoteException {
        System.out.println(" * Activating Reto: " + nombre);
        Usuario usuario = serverState.get(serverState.keySet().toArray()[0]);
        Reto reto = null;
        for(Reto r: StravaDAO.getInstance().getRetos(serverState.get(token))) {
			if(r.toString().equals(nombre)) {
				reto = r;
			}
		}
        if(reto != null) {
            RetoAppService.activateReto(reto, usuario);
        }
    }
    @Override
    public void makeSesion(SesionDTO sesiondto, long token)
            throws RemoteException {
        System.out.println(" * Making Sesion: " + sesiondto.getTitulo() + " " + sesiondto.getDeporte());
        Sesion sesion = new Sesion(sesiondto.getTitulo(), sesiondto.getDeporte(), sesiondto.getKm(), sesiondto.getfInicio(), sesiondto.getTiempo(), sesiondto.getDuracion());
        Usuario usuario = serverState.get(token);
        SesionAppService.makeSesion(sesion, usuario);
    }

    @Override
    public void makeReto(RetoDTO retodto, long token) throws RemoteException {
        System.out.println(" * Making Reto: " + retodto.getNombre() + " " + retodto.getDeporte());
        Reto reto = new Reto(retodto.getNombre(), retodto.getfInicio(), retodto.getfFin(), retodto.getDistancia(), retodto.getObjetivo(), retodto.getDeporte());
        Usuario usuario = serverState.get(token);
        RetoAppService.makeReto(reto, usuario);
    }
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public List<CategoryDTO> getCategories() throws RemoteException {
//		System.out.println(" * RemoteFacade getCategories()");
//		
//		//Get Categories using BidAppService
//		List<Category> categories = bidService.getCategories();
//		
//		if (categories != null) {
//			//Convert domain object to DTO
//			return CategoryAssembler.getInstance().categoryToDTO(categories);
//		} else {
//			throw new RemoteException("getCategories() fails!");
//		}
//	}
//
//	@Override
//	public List<ArticleDTO> getArticles(String category) throws RemoteException {
//		System.out.println(" * RemoteFacade getArticle('" + category + "')");
//
//		//Get Articles using BidAppService
//		List<Article> articles = bidService.getArticles(category);
//		
//		if (articles != null) {
//			//Convert domain object to DTO
//			return ArticleAssembler.getInstance().articleToDTO(articles);
//		} else {
//			throw new RemoteException("getArticles() fails!");
//		}
//	}
//	
//	@Override
//	public boolean makeBid(long token, int article, float amount) throws RemoteException {		
//		System.out.println(" * RemoteFacade makeBid article : " + article + " / amount " + amount);
//		
//		if (this.serverState.containsKey(token)) {						
//			//Make the bid using Bid Application Service
//			if (bidService.makeBid(this.serverState.get(token), article, amount)) {
//				return true;
//			} else {
//				throw new RemoteException("makeBid() fails!");
//			}
//		} else {
//			throw new RemoteException("To place a bid you must first log in");
//		}
//	}
//
//	@Override
//	public float getUSDRate() throws RemoteException {
//		System.out.println(" * RemoteFacade get USD rate");
//
//		//Get rate using BidAppService
//		float rate = bidService.getUSDRate();
//		
//		if (rate != -1) {
//			return rate;
//		} else {
//			throw new RemoteException("getUSDRate() fails!");
//		}
//	}
//
//	@Override
//	public float getGBPRate() throws RemoteException {
//		System.out.println(" * RemoteFacade get GBP rate");
//		
//		//Get rate using BidAppService
//		float rate = bidService.getGBPRate();
//		
//		if (rate != -1) {
//			return rate;
//		} else {
//			throw new RemoteException("getGBPRate() fails!");
//		}
//	}
}