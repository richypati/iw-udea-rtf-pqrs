package com.xyz.dto;

// Generated 4/07/2014 07:36:05 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Rol generated by hbm2java
 */
public class Rol implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Set<Rol> analistas = new HashSet<Rol>(0);

	public Rol() {
	}

	public Rol(String codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Rol(String codigo, String nombre, String descripcion, Set<Rol> analistas) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.analistas = analistas;
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Rol> getAnalistas() {
		return this.analistas;
	}

	public void setAnalistas(Set<Rol> analistas) {
		this.analistas = analistas;
	}

}
