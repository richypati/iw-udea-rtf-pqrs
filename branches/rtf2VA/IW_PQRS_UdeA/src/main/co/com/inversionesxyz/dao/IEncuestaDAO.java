package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Interface que define los metodos que va a proveer el dao de Encuesta
 * @author Jennifer Pérez
 * @author Ricardo Patiño
 *
 */
public interface IEncuestaDAO {
	/**
	 * Permite consultar la información de una encuesta según el id de una solicitud
	 * @param idSolicitud codigo de la solicitud
	 * @return Encuesta
	 * @throws BasicDBOperationException
	 */
	public Encuesta consultarPorSolicitud(int idSolicitud) throws BasicDBOperationException;
	
	/**
	 * Permite insertar una encuesta en la base de datos
	 * @param encuesta encuesta a insertar
	 * @throws BasicDBOperationException 
	 */
	public void insertar(Encuesta encuesta) throws BasicDBOperationException;
	
	/**
	 * Permite eliminar una encuesta en la base de datos
	 * @param encuesta a eliminar
	 * @throws BasicDBOperationException 
	 */
	public void eliminar(Encuesta encuesta) throws BasicDBOperationException;
}
