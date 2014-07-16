package co.com.inversionesxyz.dto;

import java.util.Date;

import org.apache.commons.lang3.Validate;

public class Encuesta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idSolicitud;
	private String respuestaPreguntaA;
	private String respuestaPreguntaB;
	private Date fechaEnvio;

	public Encuesta(String idSolicitud, String respuestaPreguntaA, String respuestaPreguntaB, Date fechaEnvio) {
		this.idSolicitud = idSolicitud;
		this.respuestaPreguntaA = respuestaPreguntaA;
		this.respuestaPreguntaB = respuestaPreguntaB;
		this.fechaEnvio = fechaEnvio;
	}

	public String getIdSolicitud() {
		return this.idSolicitud;
	}

	public void SetIdSolicitud(String idSolicitud) {
		Validate.notNull(idSolicitud, "El id de la solicitud no puede ser nulo");
		this.idSolicitud = idSolicitud;
	}

	public String getRespuestaPreguntaA() {
		return this.respuestaPreguntaA;
	}

	public void setRespuestaPreguntaA(String respuestaPreguntaA) {
		Validate.notNull(respuestaPreguntaA, "La respuesta a la pregunta A no puede ser nula");
		this.respuestaPreguntaA = respuestaPreguntaA;
	}

	public String getRespuestaPreguntaB() {
		return this.respuestaPreguntaB;
	}

	public void setRespuestaPreguntaB(String respuestaPreguntaB) {
		Validate.notNull(respuestaPreguntaB, "La respuesta a la pregunta B no puede ser nula");
		this.respuestaPreguntaB = respuestaPreguntaB;
	}

	public Date getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		Validate.notNull(fechaEnvio, "La fecha de envio no puede ser nula");
		this.fechaEnvio = fechaEnvio;
	}

}
