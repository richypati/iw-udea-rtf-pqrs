package co.com.inversionesxyz.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EmailException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(EmailException.class);

	public EmailException() {
		log.error("Ha ocurrido un error en el sistema.");
	}

	public EmailException(String message) {
		super(message);
		log.error(message);
	}

	public EmailException(Throwable cause) {
		super(cause);
		log.error("Ha ocurrido un error en el sistema.", cause);
	}

	public EmailException(String message, Throwable cause) {
		super(message, cause);
		log.error(message, cause);
	}
}
