package server.gateway;

public class LoginFactory {
	public static ILoginGateway crearLoginService(String metodo) {
        if (metodo.equals("Google")) {
        	System.out.println("eyy");
            return new LoginGoogleServiceGateway();
        } else if (metodo.equals("Facebook")) {

        	System.out.println("eyy2");
            final String serverIP = "127.0.0.1";
            final int serverPort = 35600;
            return new LoginFacebookServiceGateway(serverIP, serverPort);
        } else {
            return null;
        }
    }

}
