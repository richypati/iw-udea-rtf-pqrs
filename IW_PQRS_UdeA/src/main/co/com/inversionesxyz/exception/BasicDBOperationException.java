package co.com.inversionesxyz.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BasicDBOperationException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory
			.getLog(BasicDBOperationException.class);

	public BasicDBOperationException() {
		log.error("Ha ocurrido un error en el sistema.");
	}

	public BasicDBOperationException(String message) {
		super(message);
		log.error(message);
	}

	public BasicDBOperationException(Throwable cause) {
		super(cause);
		log.error(cause);
	}

	public BasicDBOperationException(String message, Throwable cause) {
		super(message, cause);
		log.error(message, cause);
	}

}
