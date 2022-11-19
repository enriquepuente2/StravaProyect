package ServerSrc.clases.dto;

	import java.io.Serializable;

	public class RetoDTO implements Serializable {
		private static final long serialVersionUID = 1L;
		private String nombre;
		private String fInicio;
		private String fFin;
		private double distancia;
		private double objetivo;
		private String deporte;
		private TipoDeporte tipoDeporte;
		

		public TipoDeporte getTipoDeporte() {
			return tipoDeporte;
		}

		public String getDeporte() {
			return deporte;
		}

		public void setDeporte(String deporte) {
			this.deporte = deporte;
		}



		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getfInicio() {
			return fInicio;
		}

		public void setfInicio(String fInicio) {
			this.fInicio = fInicio;
		}

		public String getfFin() {
			return fFin;
		}

		public void setfFin(String fFin) {
			this.fFin = fFin;
		}

		public double getDistancia() {
			return distancia;
		}

		public void setDistancia(double distancia) {
			this.distancia = distancia;
		}

		public double getObjetivo() {
			return objetivo;
		}

		public void setObjetivo(double objetivo) {
			this.objetivo = objetivo;
		}

		@Override
		public String toString() {
			return "RetoDTO [nombre=" + nombre + ", fInicio=" + fInicio + ", fFin=" + fFin + ", distancia=" + distancia
					+ ", objetivo=" + objetivo + ", tipoDeporte=" + tipoDeporte + "]";
		}
		
		
		
		
		
		
}



