package server.remote;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import server.clases.Usuario;
import server.dto.RetoDTO;
import server.dto.SesionDTO;
import server.dto.UsuarioDTO;
import server.services.LoginAppService;
import server.services.StravaAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private StravaAppService stravaService = new StravaAppService();
	
	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public synchronized long login(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
				
		//Perform login() using LoginAppService
		Usuario usuario = loginService.login(email, password);
			
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
	
}