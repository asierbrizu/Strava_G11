
package server.services;

import server.clases.Usuario;
import server.dto.UsuarioAssembler;
import server.dto.UsuarioDTO;
import server.gateway.ILoginGateway;
import server.gateway.LoginFactory;

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
	
	public Usuario login(String email, String password, String metodo) {
		//TODO: Get User using DAO and check 		
		System.out.println("Intentando iniciar sesion con "+email);
		Usuario usuario;		
		boolean comprobacion;
		
		switch (metodo) {
		case "Google": 
			ILoginGateway googleGateway = LoginFactory.crearLoginService("Google");
			comprobacion = googleGateway.comprobarContrasenya(email, password);
			break;
		case "Facebook":
			ILoginGateway facebookGateway = LoginFactory.crearLoginService("Facebook");
			comprobacion = facebookGateway.comprobarContrasenya(email, password);
			break;
		default:
			if (StravaAppService.usus.containsKey(email)) {
                usuario = StravaAppService.usus.get(email);
                comprobacion = usuario.comprobarContrasenya(password);
            } else {
                comprobacion = false;
            }
            break;
		}
		
		if (comprobacion) {
			System.out.println(email+" ha iniciado sesion con exito.");
			usuario=StravaAppService.usus.get(email);
			return usuario;
		} else {
			System.out.println("No se ha podido iniciar sesion");
			return null;
		}
		
		/*
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
*/	}
	
	//Registrar usuario
	
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