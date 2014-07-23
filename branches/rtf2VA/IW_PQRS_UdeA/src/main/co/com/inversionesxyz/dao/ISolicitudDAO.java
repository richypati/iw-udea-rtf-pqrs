package co.com.inversionesxyz.dao;

import java.util.List;

import co.com.inversionesxyz.dto.Solicitud;

/**
 * Interface que define los metodos que va a proveer el dao de Solicitud
 * @author Jennifer P�rez
 * @author Ricardo Pati�o
 *
 */
public interface ISolicitudDAO {
	/**
	 * Permite consultar la informaci�n de una solicitud por un campo
	 * @param campo campo de una solicitud
	 * @return Solicitud
	 */
	public Solicitud consultar(int idSolicitud);
	
	/**
	 * Permite consultar la informaci�n de una coleccion de solicitudes por un campo
	 * @param campo campo de una solicitud
	 * @return List<Solicitud>
	 */
	public List<Solicitud> consultarColeccion(String campo, String valor) ;
	
	/**
	 * Permite insertar una solicitud en la base de datos
	 * @param solicitud solicitud a insertar
	 */
	public void insertar(Solicitud solicitud);
	
	/**
	 * Permite actualizar una solicitud en la base de datos
	 * @param solicitud solicitud a actualizar
	 */
	public void actualizar(Solicitud solicitud);

	/**
	 * Permite actualizar el estado de una solicitud en la base de datos
	 * @param idSolicitud ID de la solicitud
	 * @param estado Estado de la solicitud a actualizar
	 */
	void actualizarEstado(int idSolicitud, String estado);
	
}