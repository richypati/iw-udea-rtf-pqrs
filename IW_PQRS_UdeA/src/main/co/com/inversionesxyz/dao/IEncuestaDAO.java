package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.InexistentObjectException;

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
	 * @throws InexistentObjectException
	 */
	public Encuesta consultarPorSolicitud(String idSolicitud) throws InexistentObjectException;
}
