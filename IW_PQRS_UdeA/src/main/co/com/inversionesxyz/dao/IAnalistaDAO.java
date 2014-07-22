package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.InformacionAnalista;

/**
 * Interface que define los metodos que va a proveer el dao de Analista
 * @author Jennifer Pérez
 * @author Ricardo Patiño
 *
 */
public interface IAnalistaDAO {
	/**
	 * Permite consultar la información de un analista para ser usada como detalle de una solicitud
	 * @param codigo codigo del analista
	 * @return InformacionAnalista
	 */
	public InformacionAnalista consultarPorCodigo(String codigo);
}
