package server.test;

import java.util.List;

import google.remote.ILoginGoogle;
import server.clases.Reto;
import server.clases.SesionEntrenamiento;
import server.clases.TipoUsuario;
import server.clases.Usuario;
import server.dao.UsuarioDAO;
import server.dto.RetoDTO;
import server.dto.SesionDTO;
import server.gateway.LoginGateway;
import server.gateway.LoginFactory;
import server.gateway.LoginGoogleServiceGateway;
import server.remote.RemoteFacade;

public class LocalTest {

	private ILoginGoogle google;

	public static void main(String[] args) {
		RemoteFacade facade = null;
		List<SesionDTO> sesiones = null;
		SesionDTO sesion = null;
		List<RetoDTO> retos = null;
		RetoDTO reto = null;
		long token = 0l;

		try {
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
			// Login
			// String sha1 =
			// org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
			// token = facade.login("thomas.e2001@gmail.com", sha1,"");

			token = facade.login("david@opendeusto.es", "zapatilla", TipoUsuario.GOOGLE);
			facade.logout(token);
			token = facade.login("asier@opendeusto.es", "calcetines", TipoUsuario.GOOGLE);
			facade.logout(token);
			token = facade.login("herrero@opendeusto.es", "pantalon", TipoUsuario.FACEBOOK);
			facade.logout(token);
			token = facade.login("brizuela@opendeusto.es", "camisa", TipoUsuario.FACEBOOK);
			facade.logout(token);

			retos = facade.getRetos(reto.getDeporte());
			reto = retos.get(0);
			System.out.println("\t- " + reto);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());
		}

		// Force exit to stop RMI Server
		System.exit(0);
	}
}