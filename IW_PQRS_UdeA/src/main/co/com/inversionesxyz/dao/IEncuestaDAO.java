package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.InexistentObjectException;

/**
 * Interface que define los metodos que va a proveer el dao de Encuesta
 * @author Jennifer P�rez
 * @author Ricardo Pati�o
 *
 */
public interface IEncuestaDAO {
	/**
	 * Permite consultar la informaci�n de una encuesta seg�n el id de una solicitud
	 * @param idSolicitud codigo de la solicitud
	 * @return Encuesta
	 * @throws InexistentObjectException
	 */
	public Encuesta consultarPorSolicitud(String idSolicitud) throws InexistentObjectException;
}
