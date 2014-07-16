package co.com.inversionesxyz.dto;

import org.apache.commons.lang3.Validate;

public class Cliente implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Cuenta cuenta;
	private DetalleCliente detalleCliente;

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		Validate.notNull(cuenta, "La cuenta no puede ser nula");
		this.cuenta = cuenta;
	}

	public DetalleCliente getDetalleCliente() {
		return detalleCliente;
	}

	public void setDetalleCliente(DetalleCliente detalleCliente) {
		this.detalleCliente = detalleCliente;
	}

	public static class Builder {
		private Cuenta cuenta;
		private DetalleCliente detalleCliente;
		
		public Builder conCuenta(Cuenta cuenta){
			this.cuenta = cuenta;
			return this;
		}
		
		public Builder conDetalleCliente(DetalleCliente detalleCliente){
			this.detalleCliente = detalleCliente;
			return this;
		}
		
		public Cliente build(){
			Cliente cliente = new Cliente();
			cliente.cuenta = cuenta;
			cliente.detalleCliente = detalleCliente;
			return cliente;
		}
	}
}
