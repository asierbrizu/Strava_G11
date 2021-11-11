package dto;

import java.util.ArrayList;
import java.util.List;

import clases.Reto;

public class RetoAssembler {
	private static RetoAssembler instance;

	private RetoAssembler() { }
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}
		
		return instance;
	}

	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO rto = new RetoDTO();		
		rto.setNombre(reto.getNombre());
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
