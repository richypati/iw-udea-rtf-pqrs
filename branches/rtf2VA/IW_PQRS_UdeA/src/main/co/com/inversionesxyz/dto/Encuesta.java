package co.com.inversionesxyz.dto;

import java.util.Date;

public class Encuesta implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String solicitudId;
	private Solicitud solicitud;
	private String respuestaPreguntaA;
	private String respuestaPreguntaB;
	private Date fechaEnvio;

	public Encuesta() {
	}

	public Encuesta(Solicitud solicitud, String respuestaPreguntaA,
			String respuestaPreguntaB, Date fechaEnvio) {
		this.solicitud = solicitud;
		this.respuestaPreguntaA = respuestaPreguntaA;
		this.respuestaPreguntaB = respuestaPreguntaB;
		this.fechaEnvio = fechaEnvio;
	}

	public String getSolicitudId() {
		return this.solicitudId;
	}

	public void setSolicitudId(String solicitudId) {
		this.solicitudId = solicitudId;
	}

	public Solicitud getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public String getRespuestaPreguntaA() {
		return this.respuestaPreguntaA;
	}

	public void setRespuestaPreguntaA(String respuestaPreguntaA) {
		this.respuestaPreguntaA = respuestaPreguntaA;
	}

	public String getRespuestaPreguntaB() {
		return this.respuestaPreguntaB;
	}

	public void setRespuestaPreguntaB(String respuestaPreguntaB) {
		this.respuestaPreguntaB = respuestaPreguntaB;
	}

	public Date getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

}
