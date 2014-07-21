package co.com.inversionesxyz.dao;

import java.util.List;

import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

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
	 * @throws BasicDBOperationException
	 */
	public Solicitud consultar(String campo) throws BasicDBOperationException;
	
	/**
	 * Permite consultar la información de una coleccion de solicitudes por un campo
	 * @param campo campo de una solicitud
	 * @return List<Solicitud>
	 * @throws BasicDBOperationException
	 */
	public List<Solicitud> consultarColeccion(String campo) throws BasicDBOperationException;
	
	/**
	 * Permite insertar una solicitud en la base de datos
	 * @param solicitud solicitud a insertar
	 * @throws BasicDBOperationException 
	 */
	public void insertar(Solicitud solicitud) throws BasicDBOperationException;
	
	/**
	 * Permite actualizar una solicitud en la base de datos
	 * @param solicitud solicitud a actualizar
	 * @throws BasicDBOperationException 
	 */
	public void actualizar(Solicitud solicitud) throws BasicDBOperationException;
}