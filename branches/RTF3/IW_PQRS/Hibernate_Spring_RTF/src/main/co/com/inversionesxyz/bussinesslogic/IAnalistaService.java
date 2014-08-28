package co.com.inversionesxyz.bussinesslogic;

import java.util.List;

import co.com.inversionesxyz.dto.InformacionAnalista;

/**
 * Interface que define los metodos que va a proveer la logica de negocio de la
 *  gestion de Información del Analista
 * @author Jennifer Perez
 * @author Ricardo Patino
 *
 */
public interface IAnalistaService {

	/**
	 * Permite realizar la consulta de la información de todos los Analistas
	 * @return List<InformacionAnalista> Lista de la info de todos los Analistas
	 */
	public List<InformacionAnalista> consultarAnalistas();
}
