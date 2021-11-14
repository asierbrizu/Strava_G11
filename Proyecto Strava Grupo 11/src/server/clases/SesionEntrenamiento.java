package server.clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SesionEntrenamiento {

	private String titulo;
	private String deporte;
	private float distancia;
	private String fecha_inicio;
	private int hora_inicio;//00-23
	private int duracion;//en minutos
	private Usuario creador;
	
	
	public SesionEntrenamiento(String titulo, String deporte, float distancia, String fecha_inicio, int duracion, Usuario creador) {
		super();
		this.titulo = titulo;
		this.deporte = deporte;
		this.distancia = distancia;
		this.fecha_inicio = fecha_inicio;
		this.duracion = duracion;
		this.creador = creador;
	}
	public SesionEntrenamiento() {}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public int getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(int hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	@Override
	public String toString() {
		return "SesionEntrenamiento [titulo=" + titulo + ", deporte=" + deporte + ", distancia=" + distancia
				+ ", fecha_inicio=" + fecha_inicio + ", duracion=" + duracion + ", creador=" + creador + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return ((this.titulo.equals(((SesionEntrenamiento)obj).titulo))&&(this.deporte.equals(((SesionEntrenamiento)obj).deporte)));
		}
		
		return false;
	}	
}
