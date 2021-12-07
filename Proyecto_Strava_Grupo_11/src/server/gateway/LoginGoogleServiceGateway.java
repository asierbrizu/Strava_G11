package server.gateway;

import java.rmi.Naming;
import google.remote.ILoginGoogle;
import server.clases.TipoUsuario;
public class LoginGoogleServiceGateway extends LoginGateway {

	private ILoginGoogle loginGoogleService;
	
	public LoginGoogleServiceGateway(TipoUsuario metodo) {
		super.metodo=metodo;
		try {		
			String URL = "//127.0.0.1:1099/google";
			this.loginGoogleService = (ILoginGoogle) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}
	}
	
	public boolean comprobarContrasenya(String email, String contrasenya) {
		try {
			return this.loginGoogleService.comprobarContrasenya(email,contrasenya);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return false;
	}
	
}