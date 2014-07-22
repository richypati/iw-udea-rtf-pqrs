package co.com.inversionesxyz.dto;

import org.apache.commons.lang3.Validate;

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
		Validate.notEmpty(dni, "La identificacion del analista no puede ser nula ni vacia");
		this.dni = dni;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		Validate.notEmpty(nombre, "El nombre del analista no puede ser nulo ni vacio");
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		Validate.notEmpty(correo, "El correo del analista no puede ser nulo ni vacio");
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		Validate.notEmpty(telefono, "El telefono del analista no puede ser nulo ni vacio");
		this.telefono = telefono;
	}
	

}
