package co.com.inversionesxyz.dao;

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
	 * Permite consultar la información de una solicitud por el codigo de la misma
	 * @param codigo codigo de una solicitud
	 * @return Solicitud
	 * @throws BasicDBOperationException
	 */
	public Solicitud consultarPorCodigo(String codigo) throws BasicDBOperationException;
}