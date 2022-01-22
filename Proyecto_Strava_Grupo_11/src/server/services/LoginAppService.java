
package server.services;

import java.util.HashMap;

import server.clases.TipoUsuario;
import server.clases.Usuario;
import server.dao.UsuarioDAO;
import server.dto.UsuarioAssembler;
import server.dto.UsuarioDTO;
import server.gateway.LoginGateway;
import server.gateway.LoginFactory;

public class LoginAppService {
		
	private UsuarioAssembler assamblerUser = new UsuarioAssembler();
	private HashMap<TipoUsuario, LoginGateway> gateways;
	//Instance for the Singleton Pattern
		private static LoginAppService instance;
		
		private LoginAppService() { 
			//Crear los gateways en ArrayList
			gateways = new HashMap<>();
			for (TipoUsuario tipo : TipoUsuario.values()) {
				gateways.put(tipo, LoginFactory.crearLoginService(tipo));
			}
			
		}
		
		public static LoginAppService getInstance() {
			if (instance == null) {
				instance = new LoginAppService();
			}
			
			return instance;
		}
	
	public Usuario login(String email, String password, TipoUsuario metodo) {
		System.out.println("Intentando iniciar sesion con "+email);
		Usuario usuario=UsuarioDAO.getInstance().find(email);		
		boolean comprobacion;
		
		switch (metodo) {
		case GOOGLE: 
			comprobacion = gateways.get(metodo).comprobarContrasenya(email, password);
			break;
		case FACEBOOK:
			comprobacion = gateways.get(metodo).comprobarContrasenya(email, password);
			break;
		default:
			if (usuario!=null) {
                comprobacion = usuario.comprobarContrasenya(password);
            } else {
                comprobacion = false;
            }
            break;
		}
		
		if (comprobacion) {
			System.out.println(email+" ha iniciado sesion con exito.");
			return usuario;
		} else {
			System.out.println("No se ha podido iniciar sesion");
			return null;
		}
		
		}
	
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