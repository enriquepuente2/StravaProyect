package es.deusto.ingenieria.sd.auctions.server.service;

import ServerSrc.clases.Reto;
import ServerSrc.clases.Usuario;

public class RetoAppService {
	public void activateReto(Reto reto, Usuario usuario) {
		Usuario u = LoginAppService.getMapUsuario().get(usuario.getMail());
        u.getRetosAct().add(reto);
        LoginAppService.getMapUsuario().put(usuario.getMail(), u);
    }
}
