package co.com.inversionesxyz.bussinesslogic;

import java.util.List;

import co.com.inversionesxyz.dto.Solicitud;

/**
 * Interface que define los metodos que va a proveer la logica de negocio de la gestion de solicitudes
 * @author Jennifer Perez
 * @author Ricardo Patino
 *
 */
public interface ISolicitudService {

	/**
	 * Permite almacenar una solicitud
	 * @param solicitud solicitud a almacenar
	 */
	public void guardarSolicitud(Solicitud solicitud);

	/**
	 * Permite consultar una solicitud por su identificador
	 * @param idSolicitud identificador de la solicitud a consultar
	 * @return Solicitud solicitud cuyo indentificador es igual a idSolicitud
	 */
	public Solicitud consultarSolicitud(String idSolicitud);

	/**
	 * Permite delegar una solicitud a un analista 
	 * @param idSolicitud identificador de la solicitud a delegar
	 * @param dni identificacion del analista al cual se le delega la solicitud
	 */
	public void DelegarSolicitud(String idSolicitud, String dni);

	/**
	 * Permite responder una solicitud 
	 * @param idSolicitud identificador de la solicitud a responder
	 * @param respuesta respuesta de la solicitud
	 */
	public void ResponderSolicitud(String idSolicitud, String respuesta);

	/**
	 * Permite obtener una lista de solicitudes por su estado 
	 * @param estado criterio de busqueda de las solicitudes
	 * @return List<Solicitud> lista de solicitudes que cumplen con el estado criterio
	 */
	public List<Solicitud> obtenerSolicitudesPorEstado(String estado);

	/**
	 * Permite cancelar una solicitud previamente hecha
	 * @param idSolicitud identificador de la solicitud a cancelar
	 * @param motivo motivo de la cancelacion de la solicitud
	 */
	public void CancelarSolicitud(String idSolicitud, String motivo);

	/**
	 * Permite actualizar el estado de una solicitud 
	 * @param idSolicitud identificador de la solicitud a actualizar
	 * @param estado nuevo estado de la solicitud
	 */
	public void actualizarEstadoSolicitud(String idSolicitud, String estado);

	
}
