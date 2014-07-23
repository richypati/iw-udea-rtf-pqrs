package co.com.inversionesxyz.bussinesslogic;

import java.util.List;

import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.EmailException;

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
	public Solicitud consultarSolicitud(int idSolicitud);

	/**
	 * Permite delegar una solicitud a un analista 
	 * @param idSolicitud identificador de la solicitud a delegar
	 * @param dni identificacion del analista al cual se le delega la solicitud
	 * @throws EmailException 
	 */
	public void DelegarSolicitud(int idSolicitud, String dni) throws EmailException;

	/**
	 * Permite responder una solicitud 
	 * @param Solicitud Solicitud a responder
	 * @param respuesta respuesta de la solicitud
	 * @throws EmailException 
	 */
	public void ResponderSolicitud(Solicitud idSolicitud, String respuesta) throws EmailException;

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
	 * @throws EmailException 
	 */
	public void CancelarSolicitud(int idSolicitud, String emailCliente, String motivo) throws EmailException;
	
	/**
	 * Permite actualizar una solicitud
	 * @param solicitud Solicitud a ser actualizada en la base de datos
	 */
	public void ActualizarSolicitud(Solicitud solicitud);
}
