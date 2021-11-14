package server.clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class Reto {

	private String nombre;
	private String fecha_inicio;
	private String fecha_fin;
	private float distancia_objetivo;
	private int tiempo_objetivo;//en minutos
	private String deporte;
	private Usuario creador;
	private HashSet<Usuario> usuariosApuntados;
	
	public static final SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
	
	public Reto(String nombre, String fecha_inicio, String fecha_fin, float distancia_objetivo, int tiempo_objetivo,
			String deporte, Usuario creador, HashSet<Usuario> apuntados) {
		super();
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.distancia_objetivo = distancia_objetivo;
		this.tiempo_objetivo = tiempo_objetivo;
		this.deporte = deporte;
		this.creador = creador;
	}

	public Reto() {this.usuariosApuntados=new HashSet<Usuario>();}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public float getDistancia_objetivo() {
		return distancia_objetivo;
	}

	public void setDistancia_objetivo(float distancia_objetivo) {
		this.distancia_objetivo = distancia_objetivo;
	}

	public int getTiempo_objetivo() {
		return tiempo_objetivo;
	}

	public void setTiempo_objetivo(int tiempo_objetivo) {
		this.tiempo_objetivo = tiempo_objetivo;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	
	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public HashSet<Usuario> getUsuariosApuntados() {
		return usuariosApuntados;
	}

	public void addUsuarioApuntado(Usuario usu) {
		this.usuariosApuntados.add(usu);
	}
	
	@Override
	public String toString() {
		return "Reto [nombre=" + nombre + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin
				+ ", distancia_objetivo=" + distancia_objetivo + ", tiempo_objetivo=" + tiempo_objetivo + ", deporte="
				+ deporte + ", creador=" + creador + ", usuariosApuntados=" + usuariosApuntados + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return ((this.nombre.equals(((Reto)obj).nombre))&&(this.deporte.equals(((Reto)obj).deporte)));
		}
		
		return false;
	}
	
}
