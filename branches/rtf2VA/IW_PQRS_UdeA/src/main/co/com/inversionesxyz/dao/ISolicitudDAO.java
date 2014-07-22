package co.com.inversionesxyz.dao;

import java.util.List;

import co.com.inversionesxyz.dto.Solicitud;

/**
 * Interface que define los metodos que va a proveer el dao de Solicitud
 * @author Jennifer Pérez
 * @author Ricardo Patiño
 *
 */
public interface ISolicitudDAO {
	/**
	 * Permite consultar la información de una solicitud por un campo
	 * @param campo campo de una solicitud
	 * @return Solicitud
	 */
	public Solicitud consultar(String campo);
	
	/**
	 * Permite consultar la información de una coleccion de solicitudes por un campo
	 * @param campo campo de una solicitud
	 * @return List<Solicitud>
	 */
	public List<Solicitud> consultarColeccion(String campo) ;
	
	/**
	 * Permite insertar una solicitud en la base de datos
	 * @param solicitud solicitud a insertar
	 */
	public void insertar(Solicitud solicitud);
	
	/**
	 * Permite actualizar una solicitud en la base de datos
	 * @param solicitud solicitud a actualizar
	 */
	public void actualizar(Solicitud solicitud);
}