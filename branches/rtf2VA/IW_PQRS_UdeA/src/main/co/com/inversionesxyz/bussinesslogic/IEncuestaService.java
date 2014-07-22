package co.com.inversionesxyz.bussinesslogic;


/**
 * Interface que define los metodos que va a proveer la logica de negocio de la gestion de encuestas
 * @author Jennifer Perez
 * @author Ricardo Patino
 *
 */
public interface IEncuestaService {

	/**
	 * Permite almacenar una encuesta a una solicitud
	 * @param idSolicitud identificador de la solicitud
	 * @param respuestaPreguntaA respuesta a la pregunta A de la encuesta 
	 * @param respuestaPreguntaB respuesta a la pregunta B de la encuesta
	 */
	public void almacenarEncuesta(int idSolicitud, String respuestaPreguntaA, String respuestaPreguntaB);
	
}
