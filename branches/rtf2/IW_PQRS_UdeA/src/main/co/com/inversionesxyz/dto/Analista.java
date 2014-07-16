package co.com.inversionesxyz.dto;


import org.apache.commons.lang3.Validate;

public class Analista implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cuenta cuenta;
	private Rol rol;
	private InformacionBasicaPersona informacionBasica;
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		Validate.notNull(cuenta, "La cuenta no puede ser nula");
		this.cuenta = cuenta;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		Validate.notNull(rol, "El rol no puede ser nulo");
		this.rol = rol;
	}

	public InformacionBasicaPersona getInformacionBasica() {
		return informacionBasica;
	}

	public void setInformacionBasica(InformacionBasicaPersona informacionBasica) {
		Validate.notNull(informacionBasica, "La informacion basica no puede ser nula");
		this.informacionBasica = informacionBasica;
	}

	public static class Builder {
		private Cuenta cuenta;
		private Rol rol;
		private InformacionBasicaPersona informacionBasica;
		
		public Builder conCuenta(Cuenta cuenta){
			this.cuenta = cuenta;
			return this;
		}
		
		public Builder conRol(Rol rol){
			this.rol = rol;
			return this;
		}
		
		public Builder conInformacionBasica(InformacionBasicaPersona informacionBasica){
			this.informacionBasica = informacionBasica;
			return this;
		}
		
		public Analista build(){
			Analista analista = new Analista();
			analista.cuenta = cuenta;
			analista.rol = rol;
			analista.informacionBasica = informacionBasica;
			return analista;
		}
	}

}
