package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.dto.RetoDTO;
import server.dto.SesionDTO;
import server.dto.UsuarioDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password, String metodo) throws RemoteException;
	
	public void logout(long token) throws RemoteException;

	public ArrayList<SesionDTO> getSesiones(String deporte) throws RemoteException;
	public ArrayList<RetoDTO> getRetos(String deporte) throws RemoteException;
	public UsuarioDTO getUsuario(String email, String contrasenya) throws RemoteException;
}