package co.com.inversionesxyz.dto;

import java.util.Date;

import org.apache.commons.lang3.Validate;

public class InformacionBasicaSolicitud {

	private Cliente cliente;
	private Producto producto;
	private String id;
	private String tipo;
	private String descripcion;
	private Date fechaCreacion;
	private String estado;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		Validate.notNull(cliente, "El cliente no puede ser nulo");
		this.cliente = cliente;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		Validate.notNull(producto, "El producto no puede ser nulo");
		this.producto = producto;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		Validate.notNull(id, "El id no puede ser nulo");
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		Validate.notNull(tipo, "El tipo no puede ser nulo");
		this.tipo = tipo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		Validate.notNull(descripcion, "La descripcion no puede ser nula");
		this.descripcion = descripcion;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		Validate.notNull(fechaCreacion, "La fecha de creacion no puede ser nula");
		this.fechaCreacion = fechaCreacion;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		Validate.notNull(estado, "El estado no puede ser nulo");
		this.estado = estado;
	}	
	
	public static class Builder {
		private Cliente cliente;
		private Producto producto;
		private String id;
		private String tipo;
		private String descripcion;
		private Date fechaCreacion;
		private String estado;
		
		public Builder conCliente(Cliente cliente){
			this.cliente = cliente;
			return this;
		}
		
		public Builder conProducto(Producto producto){
			this.producto = producto;
			return this;
		}
		
		public Builder conId(String id){
			this.id = id;
			return this;
		}
		
		public Builder conTipo(String tipo){
			this.tipo = tipo;
			return this;
		}
		
		public Builder conDescripcion(String descripcion){
			this.descripcion = descripcion;
			return this;
		}
		
		public Builder conFechaDeCreacion(Date fechaCreacion){
			this.fechaCreacion = fechaCreacion;
			return this;
		}
		
		public Builder conEstado(String estado){
			this.estado = estado;
			return this;
		}
		
		public InformacionBasicaSolicitud build(){
			InformacionBasicaSolicitud informacionBasicaSolicitud = new InformacionBasicaSolicitud();
			informacionBasicaSolicitud.cliente = cliente;
			informacionBasicaSolicitud.producto = producto;
			informacionBasicaSolicitud.id = id;
			informacionBasicaSolicitud.tipo = tipo;
			informacionBasicaSolicitud.descripcion = descripcion;
			informacionBasicaSolicitud.fechaCreacion = fechaCreacion;
			informacionBasicaSolicitud.estado = estado;
			return informacionBasicaSolicitud;
		}
	}
	
	
}
