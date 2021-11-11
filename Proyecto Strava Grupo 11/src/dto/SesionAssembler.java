package dto;

import java.util.ArrayList;
import java.util.List;

import clases.SesionEntrenamiento;

public class SesionAssembler {
	
		private static SesionAssembler instance;

		private SesionAssembler() { }
		
		public static SesionAssembler getInstance() {
			if (instance == null) {
				instance = new SesionAssembler();
			}
			
			return instance;
		}

		public SesionDTO sesionToDTO(SesionEntrenamiento sesion) {
			SesionDTO ses = new SesionDTO();		
			ses.setTitulo(sesion.getTitulo());
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


