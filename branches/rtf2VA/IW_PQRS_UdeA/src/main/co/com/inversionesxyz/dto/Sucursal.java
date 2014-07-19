package co.com.inversionesxyz.dto;

import java.util.HashSet;
import java.util.Set;

public class Sucursal implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String direccion;
	private String pais;
	private String ciudad;
	private Set<Producto> productos = new HashSet<Producto>(0);

	public Sucursal() {
	}

	public Sucursal(String codigo, String nombre, String direccion,
			String pais, String ciudad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.pais = pais;
		this.ciudad = ciudad;
	}

	public Sucursal(String codigo, String nombre, String direccion,
			String pais, String ciudad, Set<Producto> productos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.pais = pais;
		this.ciudad = ciudad;
		this.productos = productos;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}
