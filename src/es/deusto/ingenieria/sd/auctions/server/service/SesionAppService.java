package es.deusto.ingenieria.sd.auctions.server.service;

import ServerSrc.clases.Sesion;
import ServerSrc.clases.Usuario;

public class SesionAppService {
	public static void makeSesion(Sesion sesion, Usuario usuario) {
		Usuario u = LoginAppService.getMapUsuario().get(usuario.getMail());
		u.getSesiones().add(sesion);
        LoginAppService.getMapUsuario().put(usuario.getMail(), u);
    }
}
