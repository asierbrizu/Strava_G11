package server.gateway;

import server.domain.TipoUsuario;

public abstract class LoginGateway {
	TipoUsuario metodo;
	
	public boolean comprobarContrasenya(String email, String password) {return false;}
}
