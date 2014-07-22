package co.com.inversionesxyz.bussinesslogic;

import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.EmailException;

/**
 * Interface que define los metodos que va a proveer la logica de negocio de la gestion de solicitudes
 * @author Jennifer Perez
 * @author Ricardo Patino
 *
 */
public interface IUtilService {

	/**
	 * Permite notificar a un cliente la informacion de una solicitud
	 * @param idSolicitud identificador de la solicitud a notificar
	 * @param nombreCliente nombre del cliente al cual se le notifica acerca de la solicitud
	 * @param emailCliente correo electronico del cliente al cual se le notifica la solicitud
	 * @throws EmailException
	 */
	public void notificarSolicitudACliente(String idSolicitud, String nombreCliente, String emailCliente) throws EmailException;

	/**
	 * Permite notificar a un analista la delegacion de una solicitud
	 * @param idSolicitud identificador de la solicitud a notificar
	 * @param nombreAnalista nombre del analista al cual se le notifica acerca de la solicitud
	 * @param emailAnalista correo electronico del analista al cual se le notifica la solicitud
	 * @throws EmailException
	 */
	public void notificarSolicitudDelegada(String idSolicitud, String nombreAnalista, String emailAnalista) throws EmailException;

	/**
	 * Permite notificar a un cliente la respuesta de una solicitud
	 * @param solicitud solicitud a notificar
	 * @param emailCliente correo electronico del cliente al cual se le notifica la solicitud
	 * @throws EmailException
	 */
	public void notificarRespuestaALaSolicitud(Solicitud solicitud, String emailCliente) throws EmailException;
}