package server.gateway;

import server.domain.TipoUsuario;

public class LoginFactory {
	public static LoginGateway crearLoginService(TipoUsuario metodo) {
        switch (metodo) {
		case GOOGLE:
			return new LoginGoogleServiceGateway(metodo);
		case FACEBOOK:
			final String serverIP = "127.0.0.1";
            final int serverPort = 35600;
            return new LoginFacebookServiceGateway(serverIP, serverPort, metodo);			
		default:
			return null;
		}
		
		
		
		
    }

}
