package co.com.inversionesxyz.webservices.dto;

import org.apache.commons.lang3.Validate;

public class SolicitudWS implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigoProducto;
	private String dniAnalista;
	private String tipo;
	private String descripcion;
	private String tipoDocumento;
	private String nombreCliente;
	private String emailCliente;
	
	public SolicitudWS(){};

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
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		Validate.notEmpty(emailCliente, "El email del cliente no puede ser nulo ni vacio");
		this.emailCliente = emailCliente;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getDniAnalista() {
		return dniAnalista;
	}
	public void setDniAnalista(String dniAnalista) {
		this.dniAnalista = dniAnalista;
	}
	
}

