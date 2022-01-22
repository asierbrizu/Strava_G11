package server;

import java.rmi.Naming;

import server.clases.Reto;
import server.clases.SesionEntrenamiento;
import server.clases.Usuario;
import server.dao.UsuarioDAO;
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
		
		initDB();
		
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

	private static void initDB() {
		Usuario usu1 = new Usuario();
		usu1.setEmail("thomas.e2001@gmail.com");
		usu1.setNombre("Thomas");
		usu1.setContrasenya("$!9PhNz,");

		Usuario usu2 = new Usuario();
		usu2.setEmail("sample@gmail.com");
		usu2.setNombre("buyer33");
		usu2.setContrasenya("hqc`}3Hb");

		Usuario usuAsier = new Usuario();
		usuAsier.setEmail("asier@opendeusto.es");
		usuAsier.setNombre("Asier");
		usuAsier.setContrasenya("calcetines");

		Usuario usuDavid = new Usuario();
		usuDavid.setEmail("david@opendeusto.es");
		usuDavid.setNombre("David");
		usuDavid.setContrasenya("zapatilla");

		Usuario usuBrizuela = new Usuario();
		usuBrizuela.setEmail("brizuela@opendeusto.es");
		usuBrizuela.setNombre("Brizuela");
		usuBrizuela.setContrasenya("camisa");

		Usuario usuHerrero = new Usuario();
		usuHerrero.setEmail("herrero@opendeusto.es");
		usuHerrero.setNombre("Herrero");
		usuHerrero.setContrasenya("pantalon");

		Reto reto1 = new Reto();
		reto1.setNombre("Corriendo como loco");
		reto1.setCreador(usu2);
		reto1.setFecha_inicio("01-05-2020");
		reto1.setFecha_fin("01:06:2020");
		reto1.setDistancia_objetivo("1000");
		reto1.setDeporte("Atletismo");

		Reto reto2 = new Reto();
		reto2.setNombre("Futbol dominguero");
		reto2.setCreador(usu1);
		reto2.setFecha_inicio("03:10:2021");
		reto2.setFecha_fin("31:10:2021");
		reto2.setTiempo_objetivo(5000);
		reto2.setDeporte("Futbol");

		SesionEntrenamiento sesion1 = new SesionEntrenamiento();
		sesion1.setTitulo("Correr");
		sesion1.setDistancia("25");
		sesion1.setFecha_inicio("03:05:2020");
		sesion1.setDuracion(45);
		sesion1.setHora_inicio(07);
		sesion1.setDeporte("Atletismo");

		SesionEntrenamiento sesion2 = new SesionEntrenamiento();
		sesion2.setTitulo("Jugar Futbol");
		sesion2.setDistancia("10");
		sesion2.setFecha_inicio("11:10:2021");
		sesion2.setDuracion(90);
		sesion2.setHora_inicio(16);
		sesion2.setDeporte("Futbol");

		reto1.getUsuariosApuntados().add(usu1);
		reto2.getUsuariosApuntados().add(usu2);

		// Save Users in the DB
		UsuarioDAO.getInstance().save(usu1);
		UsuarioDAO.getInstance().save(usu2);
		UsuarioDAO.getInstance().save(usuAsier);
		UsuarioDAO.getInstance().save(usuBrizuela);
		UsuarioDAO.getInstance().save(usuDavid);
		UsuarioDAO.getInstance().save(usuHerrero);

		
	}
	
	
}

