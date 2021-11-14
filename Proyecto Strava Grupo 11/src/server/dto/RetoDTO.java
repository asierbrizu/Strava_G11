package server.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RetoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String fecha_inicio;
	private String fecha_fin;
	private float distancia_objetivo;
	private int tiempo_objetivo;//en minutos
	private String deporte;
	
	
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
	

	@Override
	public String toString() {
		return "Reto [nombre=" + nombre + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin
				+ ", distancia_objetivo=" + distancia_objetivo + ", tiempo_objetivo=" + tiempo_objetivo + ", deporte="
				+ deporte + "]";
	}
	
	
	
}
