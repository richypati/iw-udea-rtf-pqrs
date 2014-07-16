package co.com.inversionesxyz.dto;

import org.apache.commons.lang3.Validate;

public class Cuenta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombreUsuario;
	private String password;
	
	public Cuenta(String nombreUsuario, String password){
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		Validate.notNull(nombreUsuario, "El nombre de usuario no puede ser nulo");
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		Validate.notNull(password, "La clave no puede ser nula");
		this.password = password;
	}

}
