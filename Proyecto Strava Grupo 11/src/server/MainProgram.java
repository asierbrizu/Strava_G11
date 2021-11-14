package server;

import java.rmi.Naming;

import server.remote.IRemoteFacade;
import server.remote.RemoteFacade;

public class MainProgram {

	public static void main(String[] args) {	
		//Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		System.out.println("Hola, vengo a ayudarte, este es el contenido de name:" + name);
		//Bind remote facade instance to a sirvice name using RMIRegistry
		try {
			IRemoteFacade remoteFacade = new RemoteFacade();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * Servidor Strava '" + name + "' iniciado!!");
		} catch (Exception ex) {
			System.err.println(" # Strava Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}

