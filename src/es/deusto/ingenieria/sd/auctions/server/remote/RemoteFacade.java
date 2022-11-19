package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ServerSrc.clases.Usuario;
import es.deusto.ingenieria.sd.auctions.server.service.LoginAppService;
import es.deusto.ingenieria.sd.auctions.server.service.RetoAppService;
import es.deusto.ingenieria.sd.auctions.server.service.SesionAppService;



//import es.deusto.ingenieria.sd.auctions.server.data.domain.Article;
//import es.deusto.ingenieria.sd.auctions.server.data.domain.Category;
//import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
//import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleAssembler;
//import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
//import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryAssembler;
//import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;
//import es.deusto.ingenieria.sd.auctions.server.services.BidAppService;
//import es.deusto.ingenieria.sd.auctions.server.services.LoginAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private RetoAppService retoService = new RetoAppService();
	private SesionAppService sesionService = new SesionAppService();

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
	public synchronized void signup(String nombre, String email, String fechaNac, String peso, String altura, 
			String frecCardiacaMax, String frecCardiacaReposo, String contrasenia, TipoProvedor tipoProvedor) throws RemoteException {
		System.out.println(" * RemoteFacade signup(): " + nombre + " / " + contrasenia);
		
		Usuario usuario = new Usuario(nombre, email, fechaNac, peso, altura, frecCardiacaMax, frecCardiacaReposo,  contrasenia, tipoProvedor);
		
		
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
	public void singup(String nombre, String email, String fechaNac, String peso, String altura, String frecCardiacaMax,
			String frecCardiacaReposo, String contrasenia) throws RemoteException {
		// TODO Auto-generated method stub
		
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