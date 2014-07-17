package co.com.inversionesxyz.dto;

import java.util.Date;

public class Encuesta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String preguntaA;
	private String preguntaB;
	private Date fechaEnvio;

	public String getPreguntaA() {
		return this.preguntaA;
	}

	public void setPreguntaA(String preguntaA) {
		this.preguntaA = preguntaA;
	}

	public String getPreguntaB() {
		return this.preguntaB;
	}

	public void setPreguntaB(String preguntaB) {
		this.preguntaB = preguntaB;
	}

	public Date getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

}
