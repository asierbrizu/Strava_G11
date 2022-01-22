package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;

import server.clases.Reto;
import server.clases.TipoUsuario;
import server.clases.Usuario;
import server.dto.RetoDTO;
import server.dto.SesionDTO;
import server.dto.UsuarioDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password, TipoUsuario metodo) throws RemoteException;
	
	public void logout(long token) throws RemoteException;

	public ArrayList<SesionDTO> getSesiones(String deporte) throws RemoteException;
	public ArrayList<RetoDTO> getRetos(String deporte) throws RemoteException;
	public UsuarioDTO getUsuario(String email, String contrasenya) throws RemoteException;
    public void crearSesion(String titulo, String deporte, String distancia, String fecha_inicio, int duracion, long token) throws RemoteException;
    public void crearReto(String nombre, String fecha_inicio, String fecha_fin, String distancia_objetivo, int tiempo_objetivo, String deporte, HashSet<Usuario> apuntados, long token) throws RemoteException;
    public void aceptarReto(Reto reto, long token) throws RemoteException;
                   
}