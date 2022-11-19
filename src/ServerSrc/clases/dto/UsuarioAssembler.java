package ServerSrc.clases.dto;

import ServerSrc.clases.Usuario;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class UsuarioAssembler {
	private static UsuarioAssembler instance;

	private UsuarioAssembler() { }
	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}

	public UsuarioDTO userToDTO(Usuario user) {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setMail(user.getMail());
		dto.setNombre(user.getNombre());
		dto.setAltura(user.getAltura());
		dto.setfCardiacaMaxima(user.getfCardiacaMaxima());
		dto.setfCardiacaReposo(user.getfCardiacaReposo());
		dto.setfNac(user.getfNac());
		dto.setPeso(user.getPeso());
		
		return dto;
	}
}


