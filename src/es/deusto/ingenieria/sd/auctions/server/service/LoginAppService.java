package es.deusto.ingenieria.sd.auctions.server.service;

import java.util.HashMap;
import java.util.Map;

import ServerSrc.clases.Usuario;

public class LoginAppService {
	private static Map<String, Usuario> mapaUsuario= new HashMap<>() ;
	
	public boolean signup(Usuario usuario) {
		if (mapaUsuario.containsKey(usuario.getEmail())) {
			return false;
		}
		mapaUsuario.put(usuario.getEmail(), usuario);
		return true;
	}
	
	public Usuario login(String email, String contrasenia) {
		if (mapaUsuario.containsKey(email)) {
			return mapaUsuario.get(email);
		}
		return null;
	}
	
	public static Map<String, Usuario> getmapUsuario(){
		return mapaUsuario;
	}
}
