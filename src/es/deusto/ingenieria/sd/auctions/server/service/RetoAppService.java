package es.deusto.ingenieria.sd.auctions.server.service;

import ServerSrc.clases.Reto;
import ServerSrc.clases.Usuario;

public class RetoAppService {
	public static void activateReto(Reto reto, Usuario usuario) {
		Usuario u = LoginAppService.getMapUsuario().get(usuario.getMail());
        u.getRetosAct().add(reto);
        LoginAppService.getMapUsuario().put(usuario.getMail(), u);
    }
	public static void makeReto(Reto reto, Usuario user) {
        Usuario u = LoginAppService.getMapUsuario().get(user.getMail());
        u.getRetos().add(reto);
        LoginAppService.getMapUsuario().put(user.getMail(), u);
    }
}
