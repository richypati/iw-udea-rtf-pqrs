package co.com.inversionesxyz.dto;

import org.apache.commons.lang3.Validate;


public class Producto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombre;
	private String tipo;
	private float valor;
	private Sucursal sucursal;
	
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		Validate.notNull(codigo, "El codigo no puede ser nulo");
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		Validate.notNull(nombre, "El nombre no puede ser nulo");
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		Validate.notNull(tipo, "El tipo no puede ser nulo");
		this.tipo = tipo;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		Validate.notNull(valor, "El valor no puede ser nulo");
		this.valor = valor;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		Validate.notNull(sucursal, "La sucursal no puede ser nula");
		this.sucursal = sucursal;
	}
	
	public static class Builder {
		private String codigo;
		private String nombre;
		private String tipo;
		private float valor;
		private Sucursal sucursal;
		
		public Builder conCodigo(String codigo){
			this.codigo = codigo;
			return this;
		}
		
		public Builder conNombre(String nombre){
			this.nombre = nombre;
			return this;
		}
		
		public Builder conTipo(String tipo){
			this.tipo = tipo;
			return this;
		}
		
		public Builder conValor(Float valor){
			this.valor = valor;
			return this;
		}
		
		public Builder conSucursal(Sucursal sucursal){
			this.sucursal = sucursal;
			return this;
		}
		
		public Producto build(){
			Producto producto = new Producto();
			producto.codigo = codigo;
			producto.nombre = nombre;
			producto.tipo = tipo;
			producto.valor = valor;
			producto.sucursal = sucursal;
			return producto;
		}
		
		
	}

}
