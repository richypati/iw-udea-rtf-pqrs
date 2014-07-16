package co.com.inversionesxyz.dto;

import org.apache.commons.lang3.Validate;

public class InformacionBasicaPersona {

	private String dni;
	private String nombres;
	private String apellidos;
	private Ubicacion ubicacion;
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		Validate.notNull(nombres, "Los nombres no pueden ser nulos");
		this.nombres = nombres;
	}
	
	public String getApellidos(){
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		Validate.notNull(apellidos, "Los apellidos no pueden ser nulos");
		this.apellidos = apellidos;
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(Ubicacion ubicacion) {
		Validate.notNull("La ubicacion no puede ser nula");
		this.ubicacion = ubicacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		Validate.notNull(dni, "El DNI no puede ser nulo");
		this.dni = dni;
	}
	
	public static class Builder {
		private String dni;
		private String nombres;
		private String apellidos;
		private Ubicacion ubicacion;
		
		public Builder conDni(String dni){
			this.dni = dni;
			return this;
		}
		
		public Builder conNombres(String nombres){
			this.nombres = nombres;
			return this;
		}
		
		public Builder conApellidos(String apellidos){
			this.apellidos = apellidos;
			return this;
		}
		
		public Builder conUbicacion(Ubicacion ubicacion){
			this.ubicacion = ubicacion;
			return this;
		}
		
		public InformacionBasicaPersona build(){
			InformacionBasicaPersona informacionBasica = new InformacionBasicaPersona();
			informacionBasica.dni = dni;
			informacionBasica.nombres = nombres;
			informacionBasica.apellidos = apellidos;
			informacionBasica.ubicacion = ubicacion;
			return informacionBasica;
		}
	}

}
