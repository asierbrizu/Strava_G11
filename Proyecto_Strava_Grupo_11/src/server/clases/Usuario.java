package server.clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {

	private String email;
	private String contrasenya;
	private String nombre;
	private String fecha_nac;
	private float peso;
	private int altura;
	private int frecuencia_maxima;
	private int frecuencia_reposo;
	private TipoUsuario tipoUsuario;
	
	public Usuario() {}
	
	public Usuario(String email, String nombre) {
		this.email = email;
		this.nombre = nombre;
	}
	
	public Usuario(String email, String contrasenya, String nombre, String fecha_nac, float peso, int altura, int frecuencia_maxima,
			int frecuencia_reposo, TipoUsuario tipoUsuario) {
		super();
		this.email = email;
		this.contrasenya = contrasenya;
		this.nombre = nombre;
		this.fecha_nac = fecha_nac;
		this.peso = peso;
		this.altura = altura;
		this.frecuencia_maxima = frecuencia_maxima;
		this.frecuencia_reposo = frecuencia_reposo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean comprobarContrasenya(String contrasenya) {
		return this.contrasenya.equals(contrasenya);
	}
	
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getFrecuencia_maxima() {
		return frecuencia_maxima;
	}

	public void setFrecuencia_maxima(int frecuencia_maxima) {
		this.frecuencia_maxima = frecuencia_maxima;
	}

	public int getFrecuencia_reposo() {
		return frecuencia_reposo;
	}

	public void setFrecuencia_reposo(int frecuencia_reposo) {
		this.frecuencia_reposo = frecuencia_reposo;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", fecha_nac=" + fecha_nac + ", peso=" + peso
				+ ", altura=" + altura + ", frecuencia_maxima=" + frecuencia_maxima + ", frecuencia_reposo="
				+ frecuencia_reposo + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return ((this.email.equals(((Usuario)obj).email)));
		}
		
		return false;
	}
	
}
