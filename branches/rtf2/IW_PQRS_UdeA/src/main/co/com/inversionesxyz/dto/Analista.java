package co.com.inversionesxyz.dto;

public class Analista extends Persona implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
