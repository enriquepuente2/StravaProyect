package clases;

public class Sesion {
	private String titulo;
	private TipoDeporte tipoDeporte;
	private String distancia;////km, expresion regular en la ventana 
	private String fechaInicial;
	private String horaInicio;//Hora del inicio de la sesion 
	private String duracion;//en segundos, expresion regular en la ventana
	
	
	public Sesion(String titulo, TipoDeporte tipoDeporte, String distancia, String fechaInicial, String horaInicio,
			String duracion) {
		super();
		this.titulo = titulo;
		this.tipoDeporte = tipoDeporte;
		this.distancia = distancia;
		this.fechaInicial = fechaInicial;
		this.horaInicio = horaInicio;
		this.duracion = duracion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public TipoDeporte getTipoDeporte() {
		return tipoDeporte;
	}
	public void setTipoDeporte(TipoDeporte tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}
	public String getDistancia() {
		return distancia;
	}
	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	public String getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	@Override
	public String toString() {
		return "Sesion [titulo=" + titulo + ", tipoDeporte=" + tipoDeporte + ", distancia=" + distancia
				+ ", fechaInicial=" + fechaInicial + ", horaInicio=" + horaInicio + ", duracion=" + duracion + "]";
	}
	
	
}
