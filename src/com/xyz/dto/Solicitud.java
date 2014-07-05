package com.xyz.dto;

// Generated 4/07/2014 07:36:05 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Solicitud generated by hbm2java
 */
public class Solicitud implements java.io.Serializable {

	private String id;
	private Producto producto;
	private Cliente cliente;
	private Analista analista;
	private String tipo;
	private String descripcion;
	private String estado;
	private String complejidad;
	private String prioridad;
	private Date tiempoAtencion;
	private Date fechaCreacion;
	private Date fechaAtencion;

	public Solicitud() {
	}

	public Solicitud(String id, Producto producto, Cliente cliente,
			Analista analista, String tipo, String descripcion, String estado,
			Date fechaCreacion) {
		this.id = id;
		this.producto = producto;
		this.cliente = cliente;
		this.analista = analista;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
	}

	public Solicitud(String id, Producto producto, Cliente cliente,
			Analista analista, String tipo, String descripcion, String estado,
			String complejidad, String prioridad, Date tiempoAtencion,
			Date fechaCreacion, Date fechaAtencion) {
		this.id = id;
		this.producto = producto;
		this.cliente = cliente;
		this.analista = analista;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.complejidad = complejidad;
		this.prioridad = prioridad;
		this.tiempoAtencion = tiempoAtencion;
		this.fechaCreacion = fechaCreacion;
		this.fechaAtencion = fechaAtencion;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Analista getAnalista() {
		return this.analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplejidad() {
		return this.complejidad;
	}

	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}

	public String getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public Date getTiempoAtencion() {
		return this.tiempoAtencion;
	}

	public void setTiempoAtencion(Date tiempoAtencion) {
		this.tiempoAtencion = tiempoAtencion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaAtencion() {
		return this.fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

}
