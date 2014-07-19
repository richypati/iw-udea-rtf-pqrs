package co.com.inversionesxyz.dto;

import java.util.Date;

public class Solicitud implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Producto producto;
	private String tipo;
	private String descripcion;
	private String estado;
	private String complejidad;
	private String prioridad;
	private Date fechaCreacion;
	private Date fechaAtencion;
	private String tipoDocumento;
	private String nombreCliente;
	private Encuesta encuesta;

	public Solicitud() {
	}

	public Solicitud(String id, Producto producto, String tipo,
			String descripcion, String estado, Date fechaCreacion,
			String tipoDocumento, String nombreCliente) {
		this.id = id;
		this.producto = producto;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.tipoDocumento = tipoDocumento;
		this.nombreCliente = nombreCliente;
	}

	public Solicitud(String id, Producto producto, String tipo,
			String descripcion, String estado, String complejidad,
			String prioridad, Date fechaCreacion, Date fechaAtencion,
			String tipoDocumento, String nombreCliente, Encuesta encuesta) {
		this.id = id;
		this.producto = producto;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.complejidad = complejidad;
		this.prioridad = prioridad;
		this.fechaCreacion = fechaCreacion;
		this.fechaAtencion = fechaAtencion;
		this.tipoDocumento = tipoDocumento;
		this.nombreCliente = nombreCliente;
		this.encuesta = encuesta;
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

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Encuesta getEncuesta() {
		return this.encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

}

