package co.com.inversionesxyz.dto;

import org.apache.commons.lang3.Validate;


public class Producto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private Sucursal sucursal;
	private String nombre;
	private String tipo;
	private float valor;

	public String getCodigo() {
		return this.codigo;
	}
	public void setCodigo(String codigo) {
		Validate.notEmpty(codigo, "El codigo del producto no puede ser nulo ni vacio");
		this.codigo = codigo;
	}
	public Sucursal getSucursal() {
		return this.sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		Validate.notNull(sucursal, "La sucursal no puede ser nula");
		this.sucursal = sucursal;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		Validate.notEmpty(nombre, "El nombre del producto no puede ser nulo ni vacio");
		this.nombre = nombre;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		Validate.notEmpty(tipo, "El tipo del producto no puede ser nulo ni vacio");
		this.tipo = tipo;
	}
	public float getValor() {
		return this.valor;
	}
	public void setValor(float valor) {
		Validate.notNull(valor, "El valor del producto no puede ser nulo");
		this.valor = valor;
	}

}
