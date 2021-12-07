package server.dto;

import java.io.Serializable;
import java.util.Date;

import server.clases.TipoUsuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private String nombre;
	private TipoUsuario tipoUsuario;
	
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(String email, String nombre, TipoUsuario tipoUsuario) {
		this.email = email;
		this.nombre = nombre;
		this.tipoUsuario = tipoUsuario;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [email=" + email + ", nombre=" + nombre + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
	
	
	
	
}
