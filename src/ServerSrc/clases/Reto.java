package ServerSrc.clases;

public class Reto {
	private String nombre;
	private String fechaInicial;
	private String fechaFinal;
	private String tiempoObjetivo;// tiempo objetivo (50 km., 240 minutos)
	private TipoDeporte tipoDeporte;//Tipos de deporte: Ciclismo, runing o ambas
	
	
	public Reto(String nombre, String fechaInicial, String fechaFinal, String tiempoObjetivo, TipoDeporte tipoDeporte) {
		super();
		this.nombre = nombre;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.tiempoObjetivo = tiempoObjetivo;
		this.tipoDeporte = tipoDeporte;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String getTiempoObjetivo() {
		return tiempoObjetivo;
	}
	public void setTiempoObjetivo(String tiempoObjetivo) {
		this.tiempoObjetivo = tiempoObjetivo;
	}
	public TipoDeporte getTipoDeporte() {
		return tipoDeporte;
	}
	public void setTipoDeporte(TipoDeporte tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}


	@Override
	public String toString() {
		return "Reto [nombre=" + nombre + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal
				+ ", tiempoObjetivo=" + tiempoObjetivo + ", tipoDeporte=" + tipoDeporte + "]";
	}
	
	
}
