package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.InexistentObjectException;

/**
 * Interface que define los metodos que va a proveer el dao de Solicitud
 * @author Jennifer P�rez
 * @author Ricardo Pati�o
 *
 */
public interface ISolicitudDAO {
	/**
	 * Permite consultar la informaci�n de una solicitud por el codigo de la misma
	 * @param codigo codigo de una solicitud
	 * @return Solicitud
	 * @throws InexistentObjectException
	 */
	public Solicitud consultarPorCodigo(String codigo) throws InexistentObjectException;
}