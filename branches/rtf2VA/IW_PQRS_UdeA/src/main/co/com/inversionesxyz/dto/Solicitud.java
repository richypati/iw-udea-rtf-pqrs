package co.com.inversionesxyz.dto;

import java.util.Date;

public class Solicitud implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Producto producto;
	private String nombreCliente;
	private String correoCliente;
	private Analista analista;
	private String tipo;
	private String descripcion;
	private String estado;
	private String complejidad;
	private String prioridad;
	private Date fechaCreacion;
	private Date fechaAtencion;

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
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getCorreoCliente() {
		return correoCliente;
	}
	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

}
