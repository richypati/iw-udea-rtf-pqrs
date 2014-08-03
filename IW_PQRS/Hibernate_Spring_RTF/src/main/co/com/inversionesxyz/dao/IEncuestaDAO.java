package co.com.inversionesxyz.dao;

import co.com.inversionesxyz.dto.Encuesta;

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
	 */
	public Encuesta consultarPorSolicitud(int idSolicitud);
	
	/**
	 * Permite insertar una encuesta en la base de datos
	 * @param encuesta encuesta a insertar
	 */
	public void insertar(Encuesta encuesta);
	
	/**
	 * Permite eliminar una encuesta en la base de datos
	 * @param encuesta a eliminar
	 */
	public void eliminar(Encuesta encuesta);
}
