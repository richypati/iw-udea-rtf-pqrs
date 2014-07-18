// Generated 14/07/2014 11:15:24 AM by Hibernate Tools 3.4.0.CR1
package co.com.inversionesxyz.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteId id;
	private Cuenta cuenta;
	private String nombres;
	private String apellidos;
	private Date fechaNacimiento;
	private String sexo;
	private Set<Solicitud> solicituds = new HashSet<Solicitud>(0);
	private Set<DetalleCliente> detalleClientes = new HashSet<DetalleCliente>(0);

	public Cliente() {
	}

	public Cliente(ClienteId id, Cuenta cuenta, String nombres,
			String apellidos, Date fechaNacimiento, String sexo) {
		this.id = id;
		this.cuenta = cuenta;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}

	public Cliente(ClienteId id, Cuenta cuenta, String nombres,
			String apellidos, Date fechaNacimiento, String sexo,
			Set<Solicitud> solicituds, Set<DetalleCliente> detalleClientes) {
		this.id = id;
		this.cuenta = cuenta;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.solicituds = solicituds;
		this.detalleClientes = detalleClientes;
	}

	public ClienteId getId() {
		return this.id;
	}

	public void setId(ClienteId id) {
		this.id = id;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Set<Solicitud> getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(Set<Solicitud> solicituds) {
		this.solicituds = solicituds;
	}

	public Set<DetalleCliente> getDetalleClientes() {
		return this.detalleClientes;
	}

	public void setDetalleClientes(Set<DetalleCliente> detalleClientes) {
		this.detalleClientes = detalleClientes;
	}

}