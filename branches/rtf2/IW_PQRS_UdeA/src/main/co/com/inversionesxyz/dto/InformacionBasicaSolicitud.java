package co.com.inversionesxyz.dto;

import java.util.Date;

public class InformacionBasicaSolicitud {

	private String id;
	private String nobreProducto;
	private Cliente cliente;
	private String tipo;
	private String descripcion;
	private String estado;
	private Date fechaCreacion;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNobreProducto() {
		return nobreProducto;
	}
	
	public void setNobreProducto(String nobreProducto) {
		this.nobreProducto = nobreProducto;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}
