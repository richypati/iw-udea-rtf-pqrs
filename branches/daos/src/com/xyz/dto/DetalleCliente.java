package com.xyz.dto;

// Generated 4/07/2014 07:36:05 PM by Hibernate Tools 3.4.0.CR1

/**
 * DetalleCliente generated by hbm2java
 */
public class DetalleCliente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String correoElectronico;
	private Cliente cliente;
	private String direccion;
	private String telefono;
	private String celular;
	private String pais;
	private String ciudad;

	public DetalleCliente() {
	}

	public DetalleCliente(String correoElectronico, Cliente cliente,
			String direccion, String telefono, String pais, String ciudad) {
		this.correoElectronico = correoElectronico;
		this.cliente = cliente;
		this.direccion = direccion;
		this.telefono = telefono;
		this.pais = pais;
		this.ciudad = ciudad;
	}

	public DetalleCliente(String correoElectronico, Cliente cliente,
			String direccion, String telefono, String celular, String pais,
			String ciudad) {
		this.correoElectronico = correoElectronico;
		this.cliente = cliente;
		this.direccion = direccion;
		this.telefono = telefono;
		this.celular = celular;
		this.pais = pais;
		this.ciudad = ciudad;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
