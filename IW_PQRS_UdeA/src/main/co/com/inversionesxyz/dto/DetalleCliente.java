package co.com.inversionesxyz.dto;

import java.util.Date;

import org.apache.commons.lang3.Validate;

public class DetalleCliente implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String telefono;
	private String celular;
	private Date fechaNacimiento;
	private String sexo;
	private InformacionBasicaPersona informacionBasica;

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		Validate.notNull(telefono, "El telefono no puede ser nulo");
		this.telefono = telefono;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		Validate.notNull(fechaNacimiento, "La fecha de naciemiento no puede ser nula");
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		Validate.notNull(sexo, "El sexo no puede ser nulo");
		this.sexo = sexo;
	}

	public InformacionBasicaPersona getInformacionBasica() {
		return informacionBasica;
	}

	public void setInformacionBasica(InformacionBasicaPersona informacionBasica) {
		Validate.notNull(informacionBasica, "La informacion basica no puede ser nula");
		this.informacionBasica = informacionBasica;
	}

	public static class Builder {
		private String telefono;
		private String celular;
		private Date fechaNacimiento;
		private String sexo;
		private InformacionBasicaPersona informacionBasica;
		
		public Builder conTelefono(String telefono){
			this.telefono = telefono;
			return this;
		}
		
		public Builder conCelular(String celular){
			this.celular = celular;
			return this;
		}
		
		public Builder conFechaDeNacimiento(Date fechaNacimiento){
			this.fechaNacimiento = fechaNacimiento;
			return this;
		}
		
		public Builder conSexo(String sexo){
			this.sexo = sexo;
			return this;
		}
		
		public Builder conInformacionBasica(InformacionBasicaPersona informacionBasica){
			this.informacionBasica = informacionBasica;
			return this;
		}
		
		public DetalleCliente build(){
			DetalleCliente detalleCliente = new DetalleCliente();
			detalleCliente.telefono = telefono;
			detalleCliente.celular = celular;
			detalleCliente.fechaNacimiento = fechaNacimiento;
			detalleCliente.sexo = sexo;
			detalleCliente.informacionBasica = informacionBasica;
			return detalleCliente;
		}
	}

}
