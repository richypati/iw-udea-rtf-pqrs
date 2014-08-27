package co.com.inversionesxyz.dto;

import java.util.Date;

import org.apache.commons.lang3.Validate;

public class Solicitud implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Producto producto;
	private InformacionAnalista informacionAnalista;
	private String tipo;
	private String descripcion;
	private String estado;
	private String complejidad;
	private String prioridad;
	private Date fechaCreacion;
	private Date fechaAtencion;
	private String tipoDocumento;
	private String nombreCliente;
	private String emailCliente;
	private String respuestaSolicitud;
	
	public Solicitud(){};

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		Validate.notNull(id, "El ID de la solicitud no puede ser nulo");
		this.id = id;
	}
	public Producto getProducto() {
		return this.producto;
	}
	public void setProducto(Producto producto) {
		Validate.notNull(producto, "El producto no puede ser nulo ni vacio");
		this.producto = producto;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		Validate.notEmpty(tipo, "El tipo de la solicitud no puede ser nulo ni vacio");
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(String descripcion) {
		Validate.notEmpty(descripcion, "La descripcion de la solicitud no puede ser nula ni vacia");
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return this.estado;
	}
	public void setEstado(String estado) {
		Validate.notEmpty(estado, "El estado de la solicitud no puede ser nulo ni vacio");
		this.estado = estado;
	}
	public String getComplejidad() {
		return this.complejidad;
	}
	public void setComplejidad(String complejidad) {
		Validate.notEmpty(complejidad, "La coplejidad de la solicitud no puede ser nula ni vacia");
		this.complejidad = complejidad;
	}
	public String getPrioridad() {
		return this.prioridad;
	}
	public void setPrioridad(String prioridad) {
		Validate.notEmpty(prioridad, "La prioridad de la solicitud no puede ser nula ni vacia");
		this.prioridad = prioridad;
	}
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		Validate.notNull(fechaCreacion, "La fecha de creacion de la solicitud no puede ser nula");
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
		Validate.notEmpty(tipoDocumento, "El tipo de documento del cliente no puede ser nulo ni vacio");
		this.tipoDocumento = tipoDocumento;
	}
	public String getNombreCliente() {
		return this.nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		Validate.notEmpty(nombreCliente, "El nombre del cluebte no puede ser nulo ni vacio");
		this.nombreCliente = nombreCliente;
	}
	public InformacionAnalista getInformacionAnalista() {
		return informacionAnalista;
	}
	public void setInformacionAnalista(InformacionAnalista informacionAnalista) {
		Validate.notNull(informacionAnalista, "La informacion del analista no puede ser nula");
		this.informacionAnalista = informacionAnalista;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		Validate.notEmpty(emailCliente, "El email del cliente no puede ser nulo ni vacio");
		this.emailCliente = emailCliente;
	}
	public String getRespuestaSolicitud() {
		return respuestaSolicitud;
	}
	public void setRespuestaSolicitud(String respuestaSolicitud) {
		this.respuestaSolicitud = respuestaSolicitud;
	}

}

