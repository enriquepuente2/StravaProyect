package ServerSrc.clases.dto;

import java.util.ArrayList;
import java.util.List;

import ServerSrc.clases.Sesion;
	
	public class SesionAssembler {
		private static SesionAssembler instance;

		private SesionAssembler() { }
		
		public static SesionAssembler getInstance() {
			if (instance == null) {
				instance = new SesionAssembler();
			}

			return instance;
		}

		public SesionDTO sesionToDTO(Sesion sesion) {
			SesionDTO dto = new SesionDTO();
			dto.setDeporte(sesion.getDeporte());
			dto.setDuracion(sesion.getDuracion());
			dto.setfInicio(sesion.getfInicio());
			dto.setTiempo(sesion.getTiempo());
			dto.setKm(sesion.getKm());
			dto.setTitulo(sesion.getTitulo());
					
			return dto;
		}
		
		public List<SesionDTO> sesionToDTO(List<Sesion> sesions) {
			List<SesionDTO> dtos = new ArrayList<>();
			
			for (Sesion sesion : sesions) {
				dtos.add(this.sesionToDTO(sesion));
			}
			
			return dtos;		
		}
	}

