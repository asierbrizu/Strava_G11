package dto;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private String nombre;
	
	public UsuarioDTO(String email, String nombre) {
		this.email = email;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
}
