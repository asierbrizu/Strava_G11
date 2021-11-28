package server.gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class LoginFacebookServiceGateway implements ILoginGateway {
	
	private String serverIP;
	private int serverPort;
	private static String DELIMITER = "#";
	
	public LoginFacebookServiceGateway (String servIP, int servPort) {
		serverIP = servIP;
		serverPort = servPort;
	}
	
	public boolean comprobarContrasenya(String email, String contrasenya){
		String mensaje=email+DELIMITER+contrasenya;
		boolean resultado=false;
		try (Socket socket = new Socket(serverIP, serverPort);
			//Streams to send and receive information are created from the Socket
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
			
			//Send request (one String) to the server
			out.writeUTF(mensaje);			
			System.out.println(" - Sending data to '" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "' -> '" );
			resultado=in.readBoolean();			
			System.out.println(" - Getting request from '" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "' -> '");
		} catch (Exception e) {
			System.out.println("# Login. SocketGateway error: " + e.getMessage());	
		} 	
		return resultado;
	}


}