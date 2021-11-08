package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reto {

	private String nombre;
	private Date fecha_inicio;
	private Date fecha_fin;
	private float distancia_objetivo;
	private int tiempo_objetivo;//en minutos
	private String deporte;
	
	public static final SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
	
	public Reto(String nombre, Date fecha_inicio, Date fecha_fin, float distancia_objetivo, int tiempo_objetivo,
			String deporte) {
		super();
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.distancia_objetivo = distancia_objetivo;
		this.tiempo_objetivo = tiempo_objetivo;
		this.deporte = deporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
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
		return "Reto [nombre=" + nombre + ", fecha_inicio=" + formatoFecha.format(fecha_inicio) + ", fecha_fin=" + formatoFecha.format(fecha_fin)
				+ ", distancia_objetivo=" + distancia_objetivo + ", tiempo_objetivo=" + tiempo_objetivo + ", deporte="
				+ deporte + "]";
	}
	
	
}
