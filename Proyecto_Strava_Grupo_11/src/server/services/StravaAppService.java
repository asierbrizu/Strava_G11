package server.services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import server.clases.Reto;
import server.clases.SesionEntrenamiento;
import server.clases.Usuario;
import server.dto.RetoAssembler;
import server.dto.RetoDTO;
import server.dto.SesionAssembler;
import server.dto.SesionDTO;

public class StravaAppService {
	
	private static StravaAppService instance;
	
	private List<Reto> retos = new ArrayList<>();
	private List<SesionEntrenamiento> sesiones = new ArrayList<>();
	private SesionAssembler assemblerSesion = new SesionAssembler();
	private RetoAssembler assemblerReto = new RetoAssembler();
	
	public StravaAppService() {
		this.inicializarDatos();
	}
	
	private void inicializarDatos() {
		Usuario usu1 = new Usuario();
		usu1.setEmail("thomas.e2001@gmail.com");
		usu1.setNombre("Thomas");
		usu1.setContrasenya("$!9PhNz,");
		
		Usuario usu2 = new Usuario();
		usu2.setEmail("sample@gmail.com");
		usu2.setNombre("buyer33");		
		usu2.setContrasenya("hqc`}3Hb");
								


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
		
		retos.add(reto1);
		retos.add(reto2);
		
		SesionEntrenamiento sesion1= new SesionEntrenamiento();
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
		
		sesiones.add(sesion2);
		sesiones.add(sesion1);
		
		reto1.getUsuariosApuntados().add(usu1);
		reto2.getUsuariosApuntados().add(usu2);
			
	}
	
	public static StravaAppService getInstance() {
		if (instance == null) {
			instance = new StravaAppService();
		}
		
		return instance;
	}
	
	public ArrayList<RetoDTO> getRetos(String deporte) {
		ArrayList<RetoDTO> arrayRetos = new ArrayList<>();
		for (Reto r : this.retos) {
			if (r.getDeporte().equalsIgnoreCase(deporte)) {
				assemblerReto.getInstance();
				RetoDTO rto = assemblerReto.retoToDTO(r);
				arrayRetos.add(rto);
			}
		}	
		return arrayRetos;
	}
	
	public ArrayList<SesionDTO> getSesiones(String deporte) {
		ArrayList<SesionDTO> arraySesiones= new ArrayList<>();
		for (SesionEntrenamiento s : this.sesiones) {
			if (s.getDeporte().equalsIgnoreCase(deporte)) {
				assemblerSesion.getInstance();
				SesionDTO ses = assemblerSesion.sesionToDTO(s);
				arraySesiones.add(ses);
			}
		}	
		return arraySesiones;
	}
	
	
}