package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.InformacionAnalista;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Interface que define los metodos que va a proveer el dao de Analista
 * @author Jennifer P�rez
 * @author Ricardo Pati�o
 *
 */
public interface IAnalistaDAO {
	/**
	 * Permite consultar la informaci�n de un analista para ser usada como detalle de una solicitud
	 * @param codigo codigo del analista
	 * @return InformacionAnalista
	 * @throws BasicDBOperationException
	 */
	public InformacionAnalista consultarPorCodigo(String codigo) throws BasicDBOperationException;
}
