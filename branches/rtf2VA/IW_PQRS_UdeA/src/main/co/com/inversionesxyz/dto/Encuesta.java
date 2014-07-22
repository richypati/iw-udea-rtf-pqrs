package co.com.inversionesxyz.dto;

import java.util.Date;
import org.apache.commons.lang3.Validate;

public class Encuesta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int solicitudId;
	private Solicitud solicitud;
	private String respuestaPreguntaA;
	private String respuestaPreguntaB;
	private Date fechaEnvio;

	public int getSolicitudId() {
		return this.solicitudId;
	}
	public void setSolicitudId(int solicitudId) {
		Validate.notNull(solicitudId, "El ID de la solicitud no puede ser nulo");
		this.solicitudId = solicitudId;
	}
	public String getRespuestaPreguntaA() {
		return this.respuestaPreguntaA;
	}
	public void setRespuestaPreguntaA(String respuestaPreguntaA) {
		Validate.notEmpty(respuestaPreguntaA, "La respuesta a la pregunta A no puede ser nula ni vacia");
		this.respuestaPreguntaA = respuestaPreguntaA;
	}
	public String getRespuestaPreguntaB() {
		return this.respuestaPreguntaB;
	}
	public void setRespuestaPreguntaB(String respuestaPreguntaB) {
		Validate.notEmpty(respuestaPreguntaB, "La respuesta a la pregunta B no puede ser nula ni vacia");
		this.respuestaPreguntaB = respuestaPreguntaB;
	}
	public Date getFechaEnvio() {
		return this.fechaEnvio;
	}
	public void setFechaEnvio(Date fechaEnvio) {
		Validate.notNull(fechaEnvio, "La fecha de envio no puede ser nula");
		this.fechaEnvio = fechaEnvio;
	}
	public Solicitud getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(Solicitud solicitud) {
		Validate.notNull(solicitud, "La solicitud no puede ser nula");
		this.solicitud = solicitud;
	}
	
}
