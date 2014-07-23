package co.com.inversionesxyz.bussinesslogic;

import co.com.inversionesxyz.exception.EmailException;

/**
 * Interface que define los metodos que va a proveer la logica de negocio de la gestion de correos electronicos
 * @author Jennifer Perez
 * @author Ricardo Patino
 *
 */
public interface IEmailService {
	
	/**
	 * Permite enviar un correo electronico
	 * @param receiver destinatario del correo
	 * @param subject asunto del correo
	 * @param body mensaje del correo
	 * @throws EmailException
	 */
	public void enviar(String receiver, String subject, String body) throws EmailException;
}
