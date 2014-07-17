package co.com.inversionesxyz.dto;

import java.util.Date;

public class Solicitud implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private InformacionBasicaSolicitud informacionBasicaSolicitud;
	private Analista analista;	
	private String complejidad;
	private String prioridad;
	private Date tiempoAtencion;
	private Date fechaAtencion;
	
	public InformacionBasicaSolicitud getInformacionBasicaSolicitud() {		
		return informacionBasicaSolicitud;
	}
	
	public void setInformacionBasicaSolicitud(InformacionBasicaSolicitud informacionBasicaSolicitud) {
		this.informacionBasicaSolicitud = informacionBasicaSolicitud;
	}
	
	public Analista getAnalista() {
		return analista;
	}
	
	public void setAnalista(Analista analista) {
		this.analista = analista;
	}
	
	public String getComplejidad() {
		return complejidad;
	}
	
	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}
	
	public String getPrioridad() {
		return prioridad;
	}
	
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	
	public Date getTiempoAtencion() {
		return tiempoAtencion;
	}
	
	public void setTiempoAtencion(Date tiempoAtencion) {
		this.tiempoAtencion = tiempoAtencion;
	}
	
	public Date getFechaAtencion() {
		return fechaAtencion;
	}
	
	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

}
