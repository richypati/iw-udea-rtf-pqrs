package co.com.inversionesxyz.dto;

import java.util.HashSet;
import java.util.Set;

public class Producto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Sucursal sucursal;
	private String nombre;
	private String tipo;
	private float valor;
	private Set<Solicitud> solicituds = new HashSet<Solicitud>(0);

	public Producto() {
	}

	public Producto(String codigo, Sucursal sucursal, String nombre,
			String tipo, float valor) {
		this.codigo = codigo;
		this.sucursal = sucursal;
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}

	public Producto(String codigo, Sucursal sucursal, String nombre,
			String tipo, float valor, Set<Solicitud> solicituds) {
		this.codigo = codigo;
		this.sucursal = sucursal;
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
		this.solicituds = solicituds;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Set<Solicitud> getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(Set<Solicitud> solicituds) {
		this.solicituds = solicituds;
	}

}
