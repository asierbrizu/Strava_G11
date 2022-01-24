package server.dto;

import java.util.ArrayList;
import java.util.List;

import server.domain.SesionEntrenamiento;
import server.dto.SesionDTO;


public class SesionAssembler {
	
		private static SesionAssembler instance;

		public SesionAssembler() { }
		
		public static SesionAssembler getInstance() {
			if (instance == null) {
				instance = new SesionAssembler();
			}
			
			return instance;
		}

		public SesionDTO sesionToDTO(SesionEntrenamiento sesion) {
			SesionDTO ses = new SesionDTO();		
			ses.setTitulo(sesion.getTitulo());
			ses.setDeporte(sesion.getDeporte());
			ses.setDistancia(sesion.getDistancia());
			ses.setFecha_inicio(sesion.getFecha_inicio());
			ses.setHora_inicio(sesion.getHora_inicio());
			ses.setDuracion(sesion.getDuracion());
			return ses;
		}

		public List<SesionDTO> sesionToDTO(List<SesionEntrenamiento> sesiones) {		
			List<SesionDTO> sesns = new ArrayList<>();
			
			for (SesionEntrenamiento sesion : sesiones) {
				sesns.add(this.sesionToDTO(sesion));
			}
			
			return sesns;
		}
	}


