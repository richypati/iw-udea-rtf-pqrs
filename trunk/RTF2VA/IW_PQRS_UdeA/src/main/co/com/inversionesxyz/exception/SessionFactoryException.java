package co.com.inversionesxyz.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SessionFactoryException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(SessionFactoryException.class);
	
	public SessionFactoryException(){
		log.error("Ha ocurrido un error en el sistema.");
	}
	
	public SessionFactoryException(String message){
		super(message);
		log.error(message);
	}
	
	public SessionFactoryException(Throwable cause){
		super(cause);
		log.error("Ha ocurrido un error en el sistema.", cause);
	}
	
	public SessionFactoryException(String message, Throwable cause){
		super (message, cause);
		log.error(message,cause);
	}

}
