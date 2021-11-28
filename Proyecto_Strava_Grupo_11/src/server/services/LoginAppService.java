
package server.services;

import server.clases.Usuario;
import server.dto.UsuarioAssembler;
import server.dto.UsuarioDTO;

public class LoginAppService {
		
	private UsuarioAssembler assamblerUser = new UsuarioAssembler();
	
	//Instance for the Singleton Pattern
		private static LoginAppService instance;
		
		private LoginAppService() { }
		
		public static LoginAppService getInstance() {
			if (instance == null) {
				instance = new LoginAppService();
			}
			
			return instance;
		}
	
	public Usuario login(String email, String password) {
		//TODO: Get User using DAO and check 		
		Usuario usuario = new Usuario(email, password);		
		//TODO: Corregir el login
		usuario.setEmail("thomas.e2001@gmail.com");
		usuario.setNombre("Thomas");		
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		usuario.setContrasenya(sha1);
		
		if (usuario.getEmail().equals(email) && usuario.comprobarContrasenya(password)) {		
			return usuario;
		} else {
			return null;
		}
	}
	
	
	public UsuarioDTO getUsuario(String email, String contrasenya) {
		Usuario usuario= new Usuario();		
		usuario.setEmail("thomas.e2001@gmail.com");
		usuario.setNombre("Thomas");		

		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		usuario.setContrasenya(sha1);

		if (usuario.getEmail().equals(email) && usuario.comprobarContrasenya(contrasenya)) {		
			return assamblerUser.usuarioToDTO(usuario);
		} else {
			return null;
		}

	}
}