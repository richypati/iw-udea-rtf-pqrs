package co.com.inversionesxyz.dto;

import org.apache.commons.lang3.Validate;


public class Sucursal implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombre;
	private String direccion;
	private String pais;
	private String ciudad;

	public String getCodigo() {
		return this.codigo;
	}
	public void setCodigo(String codigo) {
		Validate.notNull(codigo, "El codigo de la solicitud no puede ser nulo");
		this.codigo = codigo;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		Validate.notEmpty(nombre, "El nombre de la sucursal no puede ser nulo ni vacio");
		this.nombre = nombre;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public void setDireccion(String direccion) {
		Validate.notEmpty(direccion, "La direccion de la sucursal no puede ser nula ni vacia");
		this.direccion = direccion;
	}
	public String getPais() {
		return this.pais;
	}
	public void setPais(String pais) {
		Validate.notEmpty(pais, "El pais de la sucursal no puede ser nulo ni vacio");
		this.pais = pais;
	}
	public String getCiudad() {
		return this.ciudad;
	}
	public void setCiudad(String ciudad) {
		Validate.notEmpty(ciudad, "La ciudad de la sucursal no puede ser nula ni vacia");
		this.ciudad = ciudad;
	}

}
