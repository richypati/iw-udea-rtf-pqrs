package co.com.inversionesxyz.dto;

public class InformacionAnalista implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String dni;
	private String nombre;
	private String correo;
	private String telefono;
	
	public String getDni() {
		return this.dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}
