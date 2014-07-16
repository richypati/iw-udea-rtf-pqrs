package co.com.inversionesxyz.dto;

import org.apache.commons.lang3.Validate;


public class Sucursal implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombre;

	public Sucursal(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		Validate.notNull(codigo, "El codigo no puede ser nulo");
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		Validate.notNull(nombre, "El nombre no puede ser nulo");
		this.nombre = nombre;
	}

}
