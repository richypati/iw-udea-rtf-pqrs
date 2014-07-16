package co.com.inversionesxyz.dto;

import org.apache.commons.lang3.Validate;

public class Ubicacion {

	private String direccion;
	private String ciudad;
	private String pais;
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		Validate.notNull(direccion, "La direccion no puede ser nula");
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		Validate.notNull(pais, "El pais no puede ser nulo");
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		Validate.notNull(ciudad, "La ciudad no puede ser nula");
		this.ciudad = ciudad;
	}
}
