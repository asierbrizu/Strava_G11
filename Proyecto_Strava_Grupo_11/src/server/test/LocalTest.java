package server.test;

import java.util.List;


import server.dto.RetoDTO;
import server.dto.SesionDTO;
import server.remote.RemoteFacade;

public class LocalTest {

	public static void main(String[] args) {		
		RemoteFacade facade = null;
		List<SesionDTO> sesiones = null;
		SesionDTO sesion = null;
		List<RetoDTO> retos = null;
		RetoDTO reto = null;
		long token = 0l;
		
		try {
			facade = new RemoteFacade();
			
			sesiones = facade.getSesiones("Atletismo");
			sesion = sesiones.get(0);
			
			for (SesionDTO s : sesiones) {
				System.out.println("\t- " + s);
			}			
						
			retos = facade.getRetos("Futbol");
			reto = retos.get(0);
			
			for (RetoDTO r : retos) {
				System.out.println("\t- " + r);
			}
								
		} catch (Exception e) {			
			System.out.println("\t# Error: " + e.getMessage());
		} 
		
		try {
			//Login
			String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
			token = facade.login("thomas.e2001@gmail.com", sha1);			
			//Logout
			facade.logout(token);

			retos = facade.getRetos(reto.getDeporte());
			reto = retos.get(0); 			
			System.out.println("\t- " + reto);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}

		//Force exit to stop RMI Server
		System.exit(0);
	}
}