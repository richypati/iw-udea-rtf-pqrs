package co.com.inversionesxyz.dto;

import java.util.Date;

import org.apache.commons.lang3.Validate;

public class Solicitud implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
		
	private InformacionBasicaSolicitud informacionBasicaSolicitud;	
	private Analista analista;
	private String complejidad;
	private String prioridad;
	private Date fechaAtencion;

	public String getComplejidad() {
		return this.complejidad;
	}

	public void setComplejidad(String complejidad) {
		Validate.notNull(complejidad, "La complejidad no puede ser nula");
		this.complejidad = complejidad;
	}

	public String getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(String prioridad) {
		Validate.notNull(prioridad, "La prioridad no puede ser nula");
		this.prioridad = prioridad;
	}

	public Date getFechaAtencion() {
		return this.fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public InformacionBasicaSolicitud getInformacionBasicaSolicitud() {
		return informacionBasicaSolicitud;
	}

	public void setInformacionBasicaSolicitud(InformacionBasicaSolicitud informacionBasicaSolicitud) {
		Validate.notNull(informacionBasicaSolicitud, "La informacion basica no puede ser nula");
		this.informacionBasicaSolicitud = informacionBasicaSolicitud;
	}

	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		Validate.notNull(analista, "El analista no puede ser nulo");
		this.analista = analista;
	}
	
	public static class Builder {
		private InformacionBasicaSolicitud informacionBasicaSolicitud;	
		private Analista analista;
		private String complejidad;
		private String prioridad;
		private Date fechaAtencion;
		
		public Builder conInformacionBasica(InformacionBasicaSolicitud informacionBasicaSolicitud){
			this.informacionBasicaSolicitud = informacionBasicaSolicitud;
			return this;
		}
		
		public Builder conAnalista(Analista analista){
			this.analista = analista;
			return this;
		}
		
		public Builder conComplejidad(String complejidad){
			this.complejidad = complejidad;
			return this;
		}
		
		public Builder conPrioridad(String prioridad){
			this.prioridad = prioridad;
			return this;
		}
		
		public Builder conFechaDeAtencion(Date fechaAtencion){
			this.fechaAtencion = fechaAtencion;
			return this;
		}
		
		public Solicitud build(){
			Solicitud solicitud = new Solicitud();
			solicitud.informacionBasicaSolicitud = informacionBasicaSolicitud;
			solicitud.analista = analista;
			solicitud.complejidad = complejidad;
			solicitud.prioridad = prioridad;
			solicitud.fechaAtencion = fechaAtencion;
			return solicitud;
		}
	}

}
