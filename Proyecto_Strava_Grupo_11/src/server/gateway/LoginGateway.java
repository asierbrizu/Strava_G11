package server.gateway;

import server.clases.TipoUsuario;

public abstract class LoginGateway {
	TipoUsuario metodo;
	
	public boolean comprobarContrasenya(String email, String password) {return false;}
}
