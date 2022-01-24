package server.dto;

import java.util.ArrayList;
import java.util.List;

import server.domain.TipoUsuario;
import server.domain.Usuario;

public class UsuarioAssembler {
	private static UsuarioAssembler instance;

	public UsuarioAssembler() { }
	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}

	public UsuarioDTO usuarioToDTO(Usuario usuario) {
		UsuarioDTO usu = new UsuarioDTO();
		
		usu.setEmail(usuario.getEmail());
		usu.setNombre(usuario.getNombre());
		usu.setTipoUsuario(usuario.getTipoUsuario());
		return usu;
	}
	
	public List<UsuarioDTO> usuarioToDTO(List<Usuario> usuarios) {
		List<UsuarioDTO> usus = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
			usus.add(this.usuarioToDTO(usuario));
		}
		
		return usus;		
	}

}
