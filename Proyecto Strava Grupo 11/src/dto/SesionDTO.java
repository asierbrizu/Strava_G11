package dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SesionDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String deporte;
	private float distancia;
	private Date fecha_inicio;
	private int duracion;//en minutos
	
	public static final SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat formatoHora=new SimpleDateFormat("HH:mm:ss");
	
	public SesionDTO() {
		super();
	}
	
	public SesionDTO(String titulo, String deporte, float distancia, Date fecha_inicio, int duracion) {
		super();
		this.titulo = titulo;
		this.deporte = deporte;
		this.distancia = distancia;
		this.fecha_inicio = fecha_inicio;
		this.duracion = duracion;
	}
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
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "SesionEntrenamiento [titulo=" + titulo + ", deporte=" + deporte + ", distancia=" + distancia
				+ ", fecha_inicio=" + fecha_inicio + ", duracion=" + duracion + "]";
	}
	

}
