package clienteSrc.clases;

public class Usuario {
	
	private String nombre;
	private String email;
	private String fechaNac;
	private String peso;//kilogramos, expresion regular en la ventana 
	private String altura;//metros, expresion regular en la ventana 
	private String frecCardiacaMax;//pulsaciones por segundo, expresion regular en la ventana 
	private String frecCardiacaReposo;//pulsaciones por segundo, expresion regular en la ventana 
	private String contrasenia;
	
	public Usuario(String nombre, String email, String fechaNac, String peso, String altura, String frecCardiacaMax,
			String frecCardiacaReposo, String contrasenia) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fechaNac = fechaNac;
		this.peso = peso;
		this.altura = altura;
		this.frecCardiacaMax = frecCardiacaMax;
		this.frecCardiacaReposo = frecCardiacaReposo;
		this.contrasenia = contrasenia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getFrecCardiacaMax() {
		return frecCardiacaMax;
	}
	public void setFrecCardiacaMax(String frecCardiacaMax) {
		this.frecCardiacaMax = frecCardiacaMax;
	}
	public String getFrecCardiacaReposo() {
		return frecCardiacaReposo;
	}
	public void setFrecCardiacaReposo(String frecCardiacaReposo) {
		this.frecCardiacaReposo = frecCardiacaReposo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", fechaNac=" + fechaNac + ", peso=" + peso
				+ ", altura=" + altura + ", frecCardiacaMax=" + frecCardiacaMax + ", frecCardiacaReposo="
				+ frecCardiacaReposo + ", contrasenia=" + contrasenia + "]";
	}
	
}
