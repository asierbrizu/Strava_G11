package server.remote;

import java.rmi.RemoteException;


import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import server.domain.Reto;
import server.domain.TipoUsuario;
import server.domain.Usuario;
import server.dto.RetoDTO;
import server.dto.SesionDTO;
import server.dto.UsuarioDTO;
import server.services.LoginAppService;
import server.services.StravaAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	private LoginAppService loginService = LoginAppService.getInstance();
	private StravaAppService stravaService = StravaAppService.getInstance();
	
	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public synchronized long login(String email, String password, TipoUsuario metodo) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
				
		//Perform login() using LoginAppService
		Usuario usuario = loginService.login(email, password, metodo);
		//If login() success user is stored in the Server State
		if (usuario != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(usuario)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, usuario);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	//Funcion sincronizada de registrar usuario
	
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}
	
	@Override
	public ArrayList<SesionDTO> getSesiones(String deporte) throws RemoteException {
		ArrayList<SesionDTO> ses = stravaService.getSesiones(deporte);
		return ses;
	}

	@Override
	public ArrayList<RetoDTO> getRetos(String deporte) throws RemoteException {
		ArrayList<RetoDTO> rto = stravaService.getRetos(deporte);
		return rto;
	}

	@Override
	public UsuarioDTO getUsuario(String email, String contrasenya) throws RemoteException {
		UsuarioDTO u = loginService.getUsuario(email, contrasenya);
		return u;
	}
	
	@Override
    public void crearSesion(String titulo, String deporte, String distancia, String fecha_inicio, int duracion, long token) throws RemoteException {
        if (this.serverState.containsKey(token)) {
            StravaAppService.getInstance().crearSesion(titulo, deporte, distancia, fecha_inicio, duracion, this.serverState.get(token));
            System.out.println("Creada la sesión de entrenamiento '" + titulo+ "'");
        } else {
            throw new RemoteException("Usuario no logeado");
        }
    }
	
    @Override
    public void crearReto(String nombre, String fecha_inicio, String fecha_fin, String distancia_objetivo, int tiempo_objetivo, String deporte, HashSet<Usuario> apuntados, long token) throws RemoteException {
        if (this.serverState.containsKey(token)) {
            StravaAppService.getInstance().crearReto(nombre, fecha_inicio, fecha_fin, distancia_objetivo, tiempo_objetivo, deporte, apuntados, this.serverState.get(token));
            System.out.println("Se ha creado el reto '" + nombre + "'");
        } else {
            throw new RemoteException("El usuario no esta logeado");
        }
    }

    @Override
    public void aceptarReto(Reto reto, long token) throws RemoteException {
        if (this.serverState.containsKey(token)) {
            System.out.println(" Se ha aeptado el reto " + reto);
            StravaAppService.getInstance().aceptarReto(reto, this.serverState.get(token));
        } else {
            throw new RemoteException("User not logged in");
        }
    }

    
	
}