package co.com.inversionesxyz.dao;

import java.util.List;

import co.com.inversionesxyz.dto.InformacionAnalista;

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
	 */
	public InformacionAnalista consultarPorCodigo(String codigo);
	
	/**
	 * Permite consultar la información de todos los analistas
	 * @return List<InformacionAnalista> Lista con la info de todos los Analistas
	 */
	public List<InformacionAnalista> consultarTodos();
}
