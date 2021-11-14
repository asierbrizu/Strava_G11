package server.dto;

import java.util.ArrayList;
import java.util.List;

import server.clases.Reto;

public class RetoAssembler {
	private static RetoAssembler instance;

	public RetoAssembler() { }
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}
		
		return instance;
	}

	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO rto = new RetoDTO();		
		rto.setNombre(reto.getNombre());
		rto.setFecha_inicio(reto.getFecha_inicio());
		rto.setFecha_fin(reto.getFecha_fin());
		rto.setDistancia_objetivo(reto.getDistancia_objetivo());
		rto.setTiempo_objetivo(reto.getTiempo_objetivo());
		rto.setDeporte(reto.getDeporte());
		return rto;
	}

	public List<RetoDTO> retoToDTO(List<Reto> retos) {		
		List<RetoDTO> rtos = new ArrayList<>();
		
		for (Reto reto : retos) {
			rtos.add(this.retoToDTO(reto));
		}
		
		return rtos;
	}
}
