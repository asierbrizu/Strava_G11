package server.gateway;

import java.rmi.Naming;

public class LoginGoogleServiceGateway implements ILoginGateway {

	private ILoginGateway loginGoogleService;
	
	public LoginGoogleServiceGateway() {
		try {		
			String URL = "//127.0.0.1:1099/google";
			this.loginGoogleService = (ILoginGateway) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote fa�ade: " + ex);
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