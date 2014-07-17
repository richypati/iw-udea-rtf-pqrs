package co.com.inversionesxyz.dto;

public class Cliente extends Persona implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String celular;

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}	

}
